package org.lolhens.asmpatcher.asmblock

import org.lolhens.asmpatcher.Opcode
import org.lolhens.asmpatcher.asmblock.AsmBlockParser._
import org.objectweb.asm.tree._
import java.util

/**
 * Created by LolHens on 23.12.2014.
 */
class AsmBlockParser(val asmBlock: AsmBlock = new AsmBlock()) {
  def parseInsn(_insn: String): AbstractInsnNode = {
    val insn = _insn.toLowerCase

    val opcode = Opcode(insn)
    if (opcode != null) return parseRawInsnArgs(opcode, insn.split(" ", 2)(1))

    val labelNode = parseLabel(insn)
    if (labelNode != null) return labelNode

    null
  }

  def parseRawInsnArgs(opcode: Opcode, args: String): AbstractInsnNode = {
    val split = args.split(" ")

    opcode.optype match {
      case AbstractInsnNode.FIELD_INSN => {
        parseInsnArgs(opcode, Array())
      }
      case AbstractInsnNode.METHOD_INSN => {
        val split2 = split(0).split("\\.")
        parseInsnArgs(opcode, Array(split2(0), split2(1), split(1)))
      }
      case AbstractInsnNode.TABLESWITCH_INSN => {
        ???
      }
      case AbstractInsnNode.LOOKUPSWITCH_INSN => {
        ???
      }
      case _ => parseInsnArgs(opcode, split)
    }
  }

  def parseInsnArgs(opcode: Opcode, args: Array[String]): AbstractInsnNode = {
    opcode.optype match {
      case AbstractInsnNode.INSN => new InsnNode(opcode.opcode)
      case AbstractInsnNode.INT_INSN => new IntInsnNode(opcode.opcode, args(0).toInt)
      case AbstractInsnNode.VAR_INSN => new VarInsnNode(opcode.opcode, args(0).toInt)
      case AbstractInsnNode.TYPE_INSN => new TypeInsnNode(opcode.opcode, args(0))
      case AbstractInsnNode.FIELD_INSN => new FieldInsnNode(opcode.opcode, args(0), args(1), args(2))
      case AbstractInsnNode.METHOD_INSN => new MethodInsnNode(opcode.opcode, args(0), args(1), args(2), false)
      case AbstractInsnNode.INVOKE_DYNAMIC_INSN => ???
      case AbstractInsnNode.JUMP_INSN => new JumpInsnNode(opcode.opcode, parseLabel(args(0)))
      case AbstractInsnNode.LDC_INSN => new LdcInsnNode(castLdcArg(args(0)))
      case AbstractInsnNode.IINC_INSN => new IincInsnNode(opcode.opcode, args(0).toInt)
      case AbstractInsnNode.LABEL => parseLabel(args(0)) //unused
      case AbstractInsnNode.TABLESWITCH_INSN => {
        val labels = new util.HashMap[Int, LabelNode]()
        var default: LabelNode = null
        for (i <- 0 until args.length - 1 by 2) {
          if (args(i) == "default") {
            default = parseLabel(args(i + 1))
          } else {
            val num = args(i).toInt
            labels.add(parseLabel(args(i + 1)))
          }
        }

        new TableSwitchInsnNode(args(0).toInt, args(1).toInt, parseLabel(args(args.length - 1)), labels: _*)
      }
      case AbstractInsnNode.LOOKUPSWITCH_INSN => {
        val default = parseLabel(args(0))
        val keys = new Array[Int](args.length - 1)
        val labels = new Array[LabelNode](keys.length)
        for (i <- 0 until keys.length) {
          val split = args(i + 1).split(":")
          keys(i) = split(0).toInt
          labels(i) = parseLabel(split(1).trim)
        }
        new LookupSwitchInsnNode(default, keys, labels)
      }
      case AbstractInsnNode.MULTIANEWARRAY_INSN => new MultiANewArrayInsnNode(args(0), args(1).toInt)
      case AbstractInsnNode.FRAME => ??? //unused
    }
  }

  def parseLabel(arg: String): LabelNode = {
    if (arg.toLowerCase.startsWith("l") && arg.drop(1).matches("-?\\d+"))
      asmBlock.label(arg.drop(1).toInt)
    else
      null
  }
}

object AsmBlockParser {
  private def castLdcArg(arg: String): Any = arg.toLowerCase match {
    case arg if (arg == "*") => null
    case arg if (arg.startsWith("\"") && arg.endsWith("\"")) => arg.drop(1).dropRight(1)
    case arg if (arg.endsWith("l")) => arg.dropRight(1).toLong
    case arg if (arg.endsWith("f")) => arg.dropRight(1).toFloat
    case arg if (arg.endsWith("d")) => arg.dropRight(1).toDouble
    case arg if (arg.contains(".")) => arg.toDouble
    case arg => arg.toInt
  }
}
package org.lolhens.minechanics.core.asm

import scala.collection.JavaConversions._
import java.util

object Insns {
  val insns = new util.HashMap[String, Insn]()

  case class Insn(name: String, opcode: Int) {
    insns += name -> this

    override def toString = name

    def getType = opcode
  }

  new Insn("nop", 0)
  new Insn("aconst_null", 1)
  new Insn("iconst_m1", 2)
  new Insn("iconst_0", 3)
  new Insn("iconst_1", 4)
  new Insn("iconst_2", 5)
  new Insn("iconst_3", 6)
  new Insn("iconst_4", 7)
  new Insn("iconst_5", 8)
  new Insn("lconst_0", 9)
  new Insn("lconst_1", 10)
  new Insn("fconst_0", 11)
  new Insn("fconst_1", 12)
  new Insn("fconst_2", 13)
  new Insn("dconst_0", 14)
  new Insn("dconst_1", 15)
  new Insn("bipush", 16)
  new Insn("sipush", 17)
  new Insn("ldc", 18)
  new Insn("ldc_w", 19)
  new Insn("ldc2_w", 20)
  new Insn("iload", 21)
  new Insn("lload", 22)
  new Insn("fload", 23)
  new Insn("dload", 24)
  new Insn("aload", 25)
  new Insn("iload_0", 26)
  new Insn("iload_1", 27)
  new Insn("iload_2", 28)
  new Insn("iload_3", 29)
  new Insn("lload_0", 30)
  new Insn("lload_1", 31)
  new Insn("lload_2", 32)
  new Insn("lload_3", 33)
  new Insn("fload_0", 34)
  new Insn("fload_1", 35)
  new Insn("fload_2", 36)
  new Insn("fload_3", 37)
  new Insn("dload_0", 38)
  new Insn("dload_1", 39)
  new Insn("dload_2", 40)
  new Insn("dload_3", 41)
  new Insn("aload_0", 42)
  new Insn("aload_1", 43)
  new Insn("aload_2", 44)
  new Insn("aload_3", 45)
  new Insn("iaload", 46)
  new Insn("laload", 47)
  new Insn("faload", 48)
  new Insn("daload", 49)
  new Insn("aaload", 50)
  new Insn("baload", 51)
  new Insn("caload", 52)
  new Insn("saload", 53)
  new Insn("istore", 54)
  new Insn("lstore", 55)
  new Insn("fstore", 56)
  new Insn("dstore", 57)
  new Insn("astore", 58)
  new Insn("istore_0", 59)
  new Insn("istore_1", 60)
  new Insn("istore_2", 61)
  new Insn("istore_3", 62)
  new Insn("lstore_0", 63)
  new Insn("lstore_1", 64)
  new Insn("lstore_2", 65)
  new Insn("lstore_3", 66)
  new Insn("fstore_0", 67)
  new Insn("fstore_1", 68)
  new Insn("fstore_2", 69)
  new Insn("fstore_3", 70)
  new Insn("dstore_0", 71)
  new Insn("dstore_1", 72)
  new Insn("dstore_2", 73)
  new Insn("dstore_3", 74)
  new Insn("astore_0", 75)
  new Insn("astore_1", 76)
  new Insn("astore_2", 77)
  new Insn("astore_3", 78)
  new Insn("iastore", 79)
  new Insn("lastore", 80)
  new Insn("fastore", 81)
  new Insn("dastore", 82)
  new Insn("aastore", 83)
  new Insn("bastore", 84)
  new Insn("castore", 85)
  new Insn("sastore", 86)
  new Insn("pop", 87)
  new Insn("pop2", 88)
  new Insn("dup", 89)
  new Insn("dup_x1", 90)
  new Insn("dup_x2", 91)
  new Insn("dup2", 92)
  new Insn("dup2_x1", 93)
  new Insn("dup2_x2", 94)
  new Insn("swap", 95)
  new Insn("iadd", 96)
  new Insn("ladd", 97)
  new Insn("fadd", 98)
  new Insn("dadd", 99)
  new Insn("isub", 100)
  new Insn("lsub", 101)
  new Insn("fsub", 102)
  new Insn("dsub", 103)
  new Insn("imul", 104)
  new Insn("lmul", 105)
  new Insn("fmul", 106)
  new Insn("dmul", 107)
  new Insn("idiv", 108)
  new Insn("ldiv", 109)
  new Insn("fdiv", 110)
  new Insn("ddiv", 111)
  new Insn("irem", 112)
  new Insn("lrem", 113)
  new Insn("frem", 114)
  new Insn("drem", 115)
  new Insn("ineg", 116)
  new Insn("lneg", 117)
  new Insn("fneg", 118)
  new Insn("dneg", 119)
  new Insn("ishl", 120)
  new Insn("lshl", 121)
  new Insn("ishr", 122)
  new Insn("lshr", 123)
  new Insn("iushr", 124)
  new Insn("lushr", 125)
  new Insn("iand", 126)
  new Insn("land", 127)
  new Insn("ior", 128)
  new Insn("lor", 129)
  new Insn("ixor", 130)
  new Insn("lxor", 131)
  new Insn("iinc", 132)
  new Insn("i2l", 133)
  new Insn("i2f", 134)
  new Insn("i2d", 135)
  new Insn("l2f", 136)
  new Insn("l2f", 137)
  new Insn("l2d", 138)
  new Insn("f2i", 139)
  new Insn("f2l", 140)
  new Insn("f2d", 141)
  new Insn("d2i", 142)
  new Insn("d2l", 143)
  new Insn("d2f", 144)
  new Insn("i2b", 145)
  new Insn("i2c", 146)
  new Insn("i2s", 147)
  new Insn("lcmp", 148)
  new Insn("fcmpl", 149)
  new Insn("fcmpg", 150)
  new Insn("dcmpl", 151)
  new Insn("dcmpg", 152)
  new Insn("ifeq", 153)
  new Insn("ifne", 154)
  new Insn("iflt", 155)
  new Insn("ifge", 156)
  new Insn("ifgt", 157)
  new Insn("ifle", 158)
  new Insn("if_icmpeq", 159)
  new Insn("if_acmpne", 160)
  new Insn("if_icmplt", 161)
  new Insn("if_icmpge", 162)
  new Insn("if_icmpgt", 163)
  new Insn("if_icmple", 164)
  new Insn("if_acmpeq", 165)
  new Insn("if_acmpne", 166)
  new Insn("goto", 167)
  new Insn("jsr", 168)
  new Insn("ret", 169)
  new Insn("tableswitch", 170)
  new Insn("lookupswitch", 171)
  new Insn("ireturn", 172)
  new Insn("lreturn", 173)
  new Insn("freturn", 174)
  new Insn("dreturn", 175)
  new Insn("areturn", 176)
  new Insn("return", 177)
  new Insn("getstatic", 178)
  new Insn("putstatic", 179)
  new Insn("getfield", 180)
  new Insn("putfield", 181)
  new Insn("invokevirtual", 182)
  new Insn("invokespecial", 183)
  new Insn("invokestatic", 184)
  new Insn("invokeinterface", 185)
  new Insn("unused", 186)
  new Insn("new", 187)
  new Insn("newarray", 188)
  new Insn("anewarray", 189)
  new Insn("arraylength", 190)
  new Insn("athrow", 191)
  new Insn("checkcast", 192)
  new Insn("instanceof", 193)
  new Insn("monitorenter", 194)
  new Insn("monitorexit", 195)
  new Insn("wide", 196)
  new Insn("multianewarray", 197)
  new Insn("ifnull", 198)
  new Insn("ifnonnull", 199)
  new Insn("goto_w", 200)
  new Insn("jsr_w", 201)
  new Insn("breakpoint", 202)
  new Insn("impdep1", 254)
  new Insn("impdep2", 255)
}
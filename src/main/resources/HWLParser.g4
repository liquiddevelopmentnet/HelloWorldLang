parser grammar HWLParser;

@header {
package net.liquid.hwli.ast;
}

options {
  tokenVocab=HWLLexer;
}

unit : EndOfFile;
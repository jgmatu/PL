package com.urjc.master.semv;

import com.urjc.master.semv.APITS.EnumType;

public class Commands {
	
      protected String id;
      protected EnumType tipo;

      public Commands(String id, EnumType tipo) {
            this.id = id;
            this.tipo = tipo;
      }
      
      public EnumType getTipo(){
      return this.tipo;
      }
      
      public void setTipo(EnumType tipo) {
            this.tipo = tipo;
      }
      
      public boolean equalsType(Commands c) {
    	  return this.tipo.equals(c);
      }
}
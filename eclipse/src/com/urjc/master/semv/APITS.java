package com.urjc.master.semv;

public interface APITS {

      public static enum EnumType {
            FLOAT, VOID, INT, ERROR
      };

      public static enum EnumCommands {
            FUNCTION, PARAMETERS, VARIABLE
      };

      public boolean insertaId(String id, EnumType tipo, EnumCommands cmd);
      
      public Commands buscaId(String id);

      public boolean insertaTipo(String id, EnumType tipo);

      public EnumType dameTipo(String id);

      public boolean tiposComp(EnumType tipo1, EnumType tipo2);

      //ExpTipo -> TBAS || TBAS x TBAS x TBAS || TBAS x TBAS -> TBAS

}

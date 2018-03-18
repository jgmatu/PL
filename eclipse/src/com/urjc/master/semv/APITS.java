package com.urjc.master.semv;

public interface APITS {

      public static enum EnumType {
            FLOAT, VOID, INT
      };

      public static enum EnumCommands {
            FUNCTION, PARAMETERS, VARIABLE
      };

      public boolean insertaId(EnumType tipo, String id, EnumCommands cmd);

      public Commands buscaId(String id);

      public boolean insertaTipo(Commands commands, EnumType tipo);

      public EnumType dameTipo(Commands commands);

      public boolean tiposComp(EnumType tipo1, EnumType tipo2);

      //ExpTipo -> TBAS || TBAS x TBAS x TBAS || TBAS x TBAS -> TBAS

}

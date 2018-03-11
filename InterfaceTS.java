public interface InterfaceTS {

      public enum EnumType {
            FLOAT, VOID, INT
      };

      public enum EnumCommands {
            FUNCTION, PARAMETERS, VARIABLE
      };

      public boolean insertaId(EnumType tipo, String id, EnumCommands cmd);

      public Commands buscaId(String id);

      public boolean insertaTipo(String id, EnumType tipo);

      public EnumType dameTipo(String id);

      public bool tiposComp(EnumType tipo1, EnumType tipo2);

      public bool esMatriz( EnumType tipo );

      public int daTamaño( EnumType tipo );

      public EnumType daTipoDest( EnumType tipo);

      //ExpTipo -> TBAS || TBAS x TBAS x TBAS || TBAS x TBAS -> TBAS

}

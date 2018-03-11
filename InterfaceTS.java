public interface InterfaceTS {

      public enum EnumType {
            FLOAT, VOID, INT
      };

      public enum EnumCommands {
            FUNCTION, PARAMETERS, VARIABLE
      };

      public boolean InsertaId(EnumType tipo, String id, EnumCommands cmd);

      public Commands BuscaId(String id);

      public boolean InsertaTipo(String id, EnumType tipo);

      public EnumType DameTipo(String id);

      public bool TiposComp(EnumType tipo1, EnumType tipo2);

      public bool esMatriz( EnumType tipo );

      public int DaTamaño( EnumType tipo );

      public EnumType DaTipoDest( EnumType tipo);

      //ExpTipo -> TBAS || TBAS x TBAS x TBAS || TBAS x TBAS -> TBAS

}

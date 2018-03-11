public interface InterfaceTS {

      public enum EnumType {
            FLOAT, VOID, INT
      };

      public enum EnumCommands {
            FUNCTION, PARAMETERS, VARIABLE
      };

      public boolean InsertaId(EnumType tipo, String id, EnumCommands cmd);

      public Commands BuscaId(String id);

      public boolean InsertaTipo(String id, Enum Type);

      EnumType DameTipo(String id);

      bool TiposComp(Enum Type tipo1, Enum Type tipo2);

      bool esMatriz( Enum Tipo );

      int DaTamaño( Enum Tipo );

      EnumType DaTipoDest( Enum Type );

      //ExpTipo -> TBAS || TBAS x TBAS x TBAS || TBAS x TBAS -> TBAS

}

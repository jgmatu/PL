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
      
      public setTipo(EnumType tipo) {
            this.tipo = tipo;
      }
}

public class API_TS implements InterfaceTS {

      private HashMap<String, Commands> ambito;
  private API_TS father;
      
  public API_TS(){
        this.ambito = new HashMap<String, Commands>();
        this.father = null;
      }
  
      public API_TS(API_TS father){
        this.ambito = new HashMap<String, Commands>();
        this.father = father;
      }
  
  
      public boolean insertaId(EnumType tipo, String id, EnumCommands cmd) {
        switch(cmd){
          case FUNCTION:
            // aqui el tipo se supone que es el devuelto
            this.addAmbito(id, new Function(id, tipo));
            return true;
          case PARAMETERS:
                         this.buscaId(id).insertarParametro(id, tipo);   //buscar el id en la funcion y agregarle el parametro
            return true;
          case VARIABLE:
                            this.addAmbito(id, new Variable(id, tipo));
            return true;
          default:
            //error
            return false;
        }       
      }
                                            
       public void addAmbito(String id, Commands commands) {
         this.ambito.put(id, commands);
       }

      public Commands buscaId(String id) {
        return this.ambito.get(id);
      }

      public boolean insertaTipo(Commands commands, EnumType tipo){
        commands.setTipo(tipo);
        return true;
      }

      public EnumType dameTipo(Commands commands){
        return commands.getTipo();
      }
// LOS QUe SigueN estan MAL
      public bool tiposComp(EnumType tipo1, EnumType tipo2){
        return true;
      }

      public bool esMatriz( EnumType tipo ){
        return true;
      }

      public int daTamaño( EnumType tipo ){
        return 0;
      }

      public EnumType daTipoDest( EnumType tipo ){
        return null;
      }

      //ExpTipo -> TBAS || TBAS x TBAS x TBAS || TBAS x TBAS -> TBAS

}

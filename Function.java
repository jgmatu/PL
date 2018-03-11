public class Function extends Commands {

  private List<Variable> parametros;
  
public Function(String id, EnumType tipo){
super(id, tipo);
}
  
  public void insertarParametro(String id, EnumType tipo) {
    this.parametros.add(new Variable(id, tipo);
  }
                        

}

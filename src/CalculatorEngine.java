/*
 * Laboratório de CES - 22
 * Calculadora Simples (Backend)
 */

/**
 * @author Yano / Matheus LEAO
 */
public class CalculatorEngine {
    private int value; //Valor do display
    private int keep; //Valor mantido acumulado da operação anterior
    private char toDo; //Operação a ser feita
    
    //Armazena a operação a ser realizada
    private void binaryOperation(char op) {
        keep = value;
        value = 0;
        toDo = op;
    }
    
    //Operações básicas da calculadora
    public void add() { binaryOperation('+'); }
    public void subtract() { binaryOperation('-'); }
    public void multiply() { binaryOperation('*'); }
    public void divide() { binaryOperation('/'); }
    public void equal() { compute(); }
    
    //Computa as operações acumuladas
    private void compute() {
        if (toDo == '+') {
            value = keep + value;
        }
        else if(toDo == '-') {
            value = keep - value;
        }
        else if(toDo == '*') {
            value = keep * value;
        }
        else if(toDo == '/') {
            value = keep / value;
        }
        keep = 0;
    }
    
    //Limpa os dados
    public void clear() {
        value = 0;
        keep = 0;
    }
    
    //Atualiza o valor dos dígitos após nova inserção
    public void digit(int x) {
        value = value*10 + x;
    }
    
    //Retorna o valor a ser exibido no display
    public int display() { return (value); }
    
    //Construtor
    public CalculatorEngine() { clear(); }
    
    //Função main apenas para teste
    public static void main(String arg[]) {
        CalculatorEngine c = new CalculatorEngine();
        c.digit(1);
        c.digit(3);
        c.add();
        c.digit(1);
        c.digit(1);
        c.compute();
        System.out.println(c.display());
    }
}

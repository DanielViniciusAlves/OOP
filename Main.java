import java.util.Scanner; //leitura de dados
import java.util.Random;
public class Main {
    public static int tamanho(int mes, int ano){
      int tamanho = 0;
      switch (mes) {
            case 1:
                tamanho = 31;
                break;
            case 2:
                if ((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0))) {
                    tamanho = 29;
                } else {
                    tamanho = 28;
                }
                break;
            case 3:
                tamanho = 31;
                break;
            case 4:
                tamanho = 30;
                break;
            case 5:
                tamanho = 31;
                break;
            case 6:
                tamanho = 30;
                break;
            case 7:
                tamanho = 31;
                break;
            case 8:
                tamanho = 31;
                break;
            case 9:
                tamanho = 30;
                break;
            case 10:
                tamanho = 31;
                break;
            case 11:
                tamanho = 30;
                break;
            case 12:
                tamanho = 31;
        }
      return tamanho;
    }
    public static int leituraMes(){
      int mes;
      Scanner ler = new Scanner(System.in);
        do{
          System.out.print("Digite o mes desejado:\n"); 
          while (!ler.hasNextInt()) {
            System.out.println("Nao Eh um numero valido");
            ler.next(); // this is important!
          }  
          mes = ler.nextInt();
        }while(mes <= 1 && mes >=12);
      return mes;
    }
    public static int leituraAno(){
      int ano;
      Scanner ler = new Scanner(System.in);
      do{
          System.out.print("Digite o ano desejado:\n"); 
          while (!ler.hasNextInt()) {
            System.out.println("Nao Eh um numero valido");
            ler.next(); // this is important!
          }  
          ano = ler.nextInt();
        }while(ano <= 2011 && ano >= 2020);
      return ano;
    }
    public static int[][][] entradaTemperatura(int[][][] arrayDeMeses){
        Scanner ler = new Scanner(System.in);
        int dia=1, contador=0, ano, mes, valor, tamanho;
        mes = leituraMes();
        ano = leituraAno();
        tamanho = tamanho(mes, ano);
        mes = mes - 1;
        ano = ano - 2011;
        for(int j=0; j<=tamanho-1; j++){
            System.out.print("Digite a temperatura media do dia " + dia + "\n");
            while (!ler.hasNextInt()) {
              System.out.println("Nao Eh um numero valido");
              ler.next(); // this is important!
            }   
            valor = ler.nextInt();
            arrayDeMeses[ano][mes][j] = valor;
            dia++;
        }
        return arrayDeMeses;
    }
    public static void tempMedia(int[][][] arrayDeMeses, int mes, int ano, int tamanho){
        int i=0, contador=0;
        for(int j=0; j<=tamanho-1; j++){  
            contador = contador + arrayDeMeses[ano][mes][j];
        }
        System.out.print("media " + contador/tamanho + "\n");
        return;
    }
    public static void tempMin(int[][][] arrayDeMeses, int mes, int ano, int tamanho){
        int[] arrayMinima = new int[tamanho]; 
        int i, minDia, diaEncontrado, medidor=0, contador=0;
        minDia = arrayDeMeses[ano][mes][0];
        diaEncontrado = 1;
        for(int j=1; j<tamanho; j++){
          if(minDia > arrayDeMeses[ano][mes][j]){
            minDia = arrayDeMeses[ano][mes][j];
            diaEncontrado = j+1;
          }
          else if(arrayDeMeses[ano][mes][j] == 0){
            contador++;
          }
        }
        arrayMinima[0] = diaEncontrado;
        i =1;
        for(int j=0; j<tamanho; j++){
          if(minDia == arrayDeMeses[ano][mes][j] && j != diaEncontrado - 1){
            arrayMinima[j] = j+1;
            i++;
          }
        }
        for (int j = 0; j < tamanho; j++){
        if(contador != tamanho-1 && arrayMinima[j] != 0){      
          System.out.print("Minima foi no dia " + arrayMinima[j]);
          System.out.println(", com " + minDia);
          medidor++;
        }
        }
        if(medidor == 0){
          System.out.println("Dados nao foram inseridos");
        }
        else{
          return;
        }

    }

    public static void tempMax(int[][][] arrayDeMeses, int mes, int ano, int tamanho){
        int[] arrayMaxima = new int[tamanho]; 
        int i, maxDia, diaEncontrado, medidor=0, contador=0;
        maxDia = arrayDeMeses[ano][mes][0];
        diaEncontrado = 1;
        for(int j=1; j<tamanho; j++){
          if(maxDia < arrayDeMeses[ano][mes][j]){
            maxDia = arrayDeMeses[ano][mes][j];
            diaEncontrado = j+1;
          }
          else if(arrayDeMeses[ano][mes][j] == 0){
            contador++;
          }
        }
        arrayMaxima[0] = diaEncontrado;
        i =1;
        for(int j=0; j<tamanho; j++){
          if(maxDia == arrayDeMeses[ano][mes][j] && j != diaEncontrado - 1){
            arrayMaxima[j] = j+1;
            i++;
          }
        }
        for (int j = 0; j < tamanho; j++){
        if(contador != tamanho-1 && arrayMaxima[j] != 0){      
          System.out.print("Maxima foi no dia " + arrayMaxima[j]);
          System.out.println(", com " + maxDia);
          medidor++;
        }
        }
        if(medidor == 0){
          System.out.println("Dados nao foram inseridos");
        }
        else{
          return;
        }

    }
    public static void printaArray(int tamanho, int[][][]arrayDeMeses, int mes, int ano){
      int y;
        for(int x=0; x<tamanho; x++){
        y = x+1;
        System.out.println("Dia " + y + " - " + arrayDeMeses[ano][mes][x]);
      }
    }
    public static void main(String[] args) {
        char opcao;
        int mes, ano, tamanho, y;
        int[][][] arrayDeMeses = new int[10][12][31];
        for(int i=0;i<31;i++){
            arrayDeMeses[9][0][i]= (int)(Math.random() * 100);
        }
        Scanner ler = new Scanner(System.in);
        do{
        System.out.print("Digite a opcao desejada:\n"); 
        System.out.print("1.Entrada das temperaturas:\n"); 
        System.out.print("2.Cálculo  da  temperatura  média:\n");
        System.out.print("3.Cálculo  da  temperatura  mínima:\n");
        System.out.print("4.Cálculo  da  temperatura  máxima:\n");
        System.out.print("5.Relatório meteorológico:\n");
        System.out.print("Digite 'e' para sair do programa\n");
        opcao = ler.next().charAt(0); 
        switch( opcao )
        {
            case '1':
                // funcao que recebe string do mes
                arrayDeMeses = entradaTemperatura(arrayDeMeses);
                break;        
                
            case '2':
                mes = leituraMes();
                ano = leituraAno();
                tamanho = tamanho(mes, ano);
                mes = mes - 1;
                ano = ano - 2011;
                tamanho = tamanho(mes, ano);
                tempMedia(arrayDeMeses, mes, ano, tamanho);
                break;
                
            case '3':
                mes = leituraMes();
                ano = leituraAno();
                tamanho = tamanho(mes, ano);
                mes = mes - 1;
                ano = ano - 2011;
                tamanho = tamanho(mes, ano);
                tempMin(arrayDeMeses, mes, ano, tamanho);
                break;
            
            case '4':
                mes = leituraMes();
                ano = leituraAno();
                tamanho = tamanho(mes, ano);
                mes = mes - 1;
                ano = ano - 2011;
                tempMax(arrayDeMeses, mes, ano, tamanho);
                break;

            case '5':
                mes = leituraMes();
                ano = leituraAno();
                tamanho = tamanho(mes, ano);
                mes = mes - 1;
                ano = ano - 2011;
                tempMedia(arrayDeMeses, mes, ano, tamanho);
                tempMin(arrayDeMeses,  mes, ano, tamanho);
                tempMax(arrayDeMeses,  mes, ano, tamanho);
                printaArray(tamanho, arrayDeMeses, mes, ano);
                break;
            
        } 
    }while(opcao != 'e');
    System.out.print("Saindo do programa\n");
    }
}
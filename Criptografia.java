
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Criptografia {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Character> alfabeto = new ArrayList<>();

        System.out.println("Digite a sua senha:");
        String senha = scan.nextLine().toUpperCase();

        System.out.println("DIgite o deslocamento:");
        int salt = scan.nextInt();

        for (char i = 'A'; i <= 'Z'; i++) {
            alfabeto.add(i);
        }

        StringBuilder resultado = cripto(senha, salt, alfabeto);

        System.out.print("Hash: " + resultado.toString().toLowerCase());
        System.out.println();
        resultado = decripto(resultado.toString(), salt, alfabeto);

        System.out.print("Senha: " + resultado.toString().toLowerCase());

        scan.close();
    }

    public static StringBuilder cripto(String senha, int chave, List<Character> alfabeto) {
        StringBuilder resultado = new StringBuilder();

        for (char c : senha.toCharArray()) {
            int novoChar = ((alfabeto.indexOf(c)) + chave) % 26;
            resultado.append(alfabeto.get(novoChar));
        }
        return resultado;
    }

    public static StringBuilder decripto(String senha, int chave, List<Character> alfabeto) {
        StringBuilder resultado = new StringBuilder();

        for (char c : senha.toCharArray()) {
            int novoChar = ((alfabeto.indexOf(c)) - chave) % 26;
            resultado.append(alfabeto.get(novoChar));
        }
        return resultado;
    }
}

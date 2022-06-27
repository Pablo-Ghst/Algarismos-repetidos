import javax.swing.JOptionPane;

import java.util.HashMap;

import java.util.Map;

import java.util.stream.IntStream;

public class AlgarismosRepetidos {

public static void main(String[] args) {

String display = "";

String size = JOptionPane.showInputDialog("Digite a quantidade de caractéres do seu número");

int newsize = Integer.parseInt(size);

if (newsize < 0) {//porque o usuário pode entrar com um valor inválido. Vamos evitar:

JOptionPane.showMessageDialog(null, "Número inválido. (Apenas números inteiros.");

System.exit(0);

}

JOptionPane.showMessageDialog(null, "Você definiu como: " + newsize + ".");

int array[] = new int[newsize];

for (int a = 0; a < array.length; a++) {

array[a] = Integer.parseInt(JOptionPane.showInputDialog("Qual o valor para a posição? [" + a + "]."));

System.out.println(array[a]);

display = display + array[a] + "\n";

}

int count = 0;

Map<Integer, Integer> repeatCounter = new HashMap<>();//vamos rodar o array que o usuário deu input e aplicar as regras.

for (int i : array) {

if (repeatCounter.containsKey(i)) {

int repeatedNTimes = repeatCounter.get(i);

repeatCounter.put(i, repeatedNTimes + 1);

} else {

repeatCounter.put(i, 1);

}

}

for (int b : array) {

int indexOfElement = IntStream.range(0, array.length).filter(i -> b == array[i]).findFirst().orElse(-1);

if (repeatCounter.get(b) == 3) {

count++;

if (count == 2) {

JOptionPane.showMessageDialog(null, "Há uma sequência de algarismo " + b

+ " repetidos três vezes consecutivas com início na posição " + indexOfElement);

break;

}

}

}

JOptionPane.showMessageDialog(null, "Obrigado!");

}

}
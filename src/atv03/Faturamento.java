package atv03;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Faturamento {
    public static void main(String[] args) {
        String jsonFilePath = "src/atv03/dados.json";
        List<Double> faturamentoValores = lerFaturamentoDoArquivo(jsonFilePath);

        if (faturamentoValores.isEmpty()) {
            System.out.println("Nao ha dados de faturamento para processamento.");
            return;
        }

        double menorFaturamento = encontrarMenorFaturamento(faturamentoValores);
        double maiorFaturamento = encontrarMaiorFaturamento(faturamentoValores);
        double somaFaturamento = calcularSomaFaturamento(faturamentoValores);
        double mediaFaturamento = calcularMediaFaturamento(somaFaturamento, faturamentoValores.size());
        int diasAcimaDaMedia = contarDiasAcimaDaMedia(faturamentoValores, mediaFaturamento);

        imprimirResultados(menorFaturamento, maiorFaturamento, mediaFaturamento, diasAcimaDaMedia);
    }

    private static List<Double> lerFaturamentoDoArquivo(String filePath) {
        List<Double> faturamentoValores = new ArrayList<>();
        try (FileReader fileReader = new FileReader(filePath)) {
            StringBuilder jsonContent = new StringBuilder();
            int character;
            while ((character = fileReader.read()) != -1) {
                jsonContent.append((char) character);
            }

            JSONArray faturamentoArray = new JSONArray(jsonContent.toString());

            for (int i = 0; i < faturamentoArray.length(); i++) {
                JSONObject item = faturamentoArray.getJSONObject(i);
                double valor = item.getDouble("valor");
                if (valor > 0) {
                    faturamentoValores.add(valor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return faturamentoValores;
    }

    private static double encontrarMenorFaturamento(List<Double> valores) {
        double menorFaturamento = valores.get(0);
        for (double valor : valores) {
            if (valor < menorFaturamento) {
                menorFaturamento = valor;
            }
        }
        return menorFaturamento;
    }

    private static double encontrarMaiorFaturamento(List<Double> valores) {
        double maiorFaturamento = valores.get(0);
        for (double valor : valores) {
            if (valor > maiorFaturamento) {
                maiorFaturamento = valor;
            }
        }
        return maiorFaturamento;
    }

    private static double calcularSomaFaturamento(List<Double> valores) {
        double somaFaturamento = 0;
        for (double valor : valores) {
            somaFaturamento += valor;
        }
        return somaFaturamento;
    }

    private static double calcularMediaFaturamento(double somaFaturamento, int quantidadeValores) {
        return somaFaturamento / quantidadeValores;
    }

    private static int contarDiasAcimaDaMedia(List<Double> valores, double mediaFaturamento) {
        int diasAcimaDaMedia = 0;
        for (double valor : valores) {
            if (valor > mediaFaturamento) {
                diasAcimaDaMedia++;
            }
        }
        return diasAcimaDaMedia;
    }

    private static void imprimirResultados(double menorFaturamento, double maiorFaturamento, double mediaFaturamento, int diasAcimaDaMedia) {
        System.out.printf("Menor valor de faturamento: R$ %.2f%n" , menorFaturamento);
        System.out.printf("Maior valor de faturamento: R$ %.2f%n" , maiorFaturamento);
        System.out.printf("Media mensal de faturamento: R$ %.2f%n", mediaFaturamento);
        System.out.println("Numero de dias com faturamento acima da media mensal: " + diasAcimaDaMedia);
        
    }
}

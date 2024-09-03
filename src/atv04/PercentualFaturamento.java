package atv04;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PercentualFaturamento {

    public static void main(String[] args) {
        String arquivo = "src/atv04/faturamento.txt";
        Map<String, Double> faturamento = new HashMap<>();
        double total = 0;

        
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(":");
                String estado = partes[0];
                double valor = Double.parseDouble(partes[1]);
                faturamento.put(estado, valor);
                total += valor;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        for (Map.Entry<String, Double> entrada : faturamento.entrySet()) {
            String estado = entrada.getKey();
            double valor = entrada.getValue();
            double percentual = (valor / total) * 100;
            System.out.printf("Percentual de %s: %.2f%%\n", estado, percentual);
        }
    }
}


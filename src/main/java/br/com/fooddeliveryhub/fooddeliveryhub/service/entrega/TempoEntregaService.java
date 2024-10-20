package br.com.fooddeliveryhub.fooddeliveryhub.service.entrega;

public class TempoEntregaService {
    
    private static final double VELOCIDADE_MEDIA_KMH = 40.0;

    // Método que calcula o tempo estimado com base na distância
    public double calcularTempoEstimado(double distanciaKm) {
        return distanciaKm / VELOCIDADE_MEDIA_KMH; // Tempo em horas
    }
}

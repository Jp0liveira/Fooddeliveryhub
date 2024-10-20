package br.com.fooddeliveryhub.fooddeliveryhub.service.entrega;

public class DistanciaService {
    
    // Usando a fórmula de Haversine para calcular a distância 
    private static final int RAIO_TERRA_KM = 6371;

    public double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.sin(dLon / 2) * Math.sin(dLon / 2) *
                   Math.cos(lat1) * Math.cos(lat2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        
        return RAIO_TERRA_KM * c; // Distância em quilômetros
    }
}

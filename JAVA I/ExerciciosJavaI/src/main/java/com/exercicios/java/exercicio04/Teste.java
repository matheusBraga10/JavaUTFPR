package com.exercicios.java.exercicio04;

public class Teste {
    public static void main(String arg[]) {

        Passeio passeio1 = new Passeio();
        Passeio passeio2 = new Passeio();
        Passeio passeio3 = new Passeio();
        Passeio passeio4 = new Passeio();
        Passeio passeio5 = new Passeio();
        
        Carga carga1 = new Carga();
        Carga carga2 = new Carga();
        Carga carga3 = new Carga();
        Carga carga4 = new Carga();
        Carga carga5 = new Carga();

        passeio1.setVelocMax(300);
        passeio1.setQtdRodas(4);
        passeio1.setQtdPassageiros(1);
        passeio1.setPlaca("abc-1234");
        passeio1.setMotor(new Motor());
        passeio1.setModelo("delta");
        passeio1.setMarca("BWM");
        passeio1.setCor("verde");

        passeio2.setVelocMax(100);

        passeio3.setVelocMax(80);

        passeio4.setVelocMax(200);

        passeio5.setVelocMax(300);
        
        carga1.setCargaMax(2);
        carga1.setCor("Azul");
        carga1.setMarca("Mercedes");
        carga1.setModelo("Baú");
        carga1.setMotor(new Motor());
        carga1.setPlaca("zxw-1234");
        carga1.setQtdRodas(16);
        carga1.setTara(2500);
        carga1.setVelocMax(120);

        carga2.setVelocMax(80);
        
        carga3.setVelocMax(110);
        
        carga4.setVelocMax(100);
        
        carga5.setVelocMax(50);
        
        System.out.println("-----------------------------------");
        System.out.println("\t\t\t Dados do Veículos de Passeio");
        System.out.println("-----------------------------------");
        System.out.println("Velocidade máxima do veículo de passeio 1: " + passeio1.calcVel(passeio1.getVelocMax()) + " m/h.");
        System.out.println("Velocidade máxima do veículo de passeio 2: " + passeio2.calcVel(passeio2.getVelocMax()) + " m/h.");
        System.out.println("Velocidade máxima do veículo de passeio 3: " + passeio3.calcVel(passeio3.getVelocMax()) + " m/h.");
        System.out.println("Velocidade máxima do veículo de passeio 4: " + passeio4.calcVel(passeio4.getVelocMax()) + " m/h.");
        System.out.println("Velocidade máxima do veículo de passeio 5: " + passeio5.calcVel(passeio5.getVelocMax()) + " m/h.");

        System.out.println("\n\n-----------------------------------");
        System.out.println("\t\t\t Dados do Veículos de Carga");
        System.out.println("-----------------------------------");
        System.out.println("Carga máxima do veículo de carga 1: " + carga1.calcVel(carga1.getVelocMax()) + " cm/h.");
        System.out.println("Carga máxima do veículo de carga 2: " + carga2.calcVel(carga2.getVelocMax()) + " cm/h.");
        System.out.println("Carga máxima do veículo de carga 3: " + carga3.calcVel(carga3.getVelocMax()) + " cm/h.");
        System.out.println("Carga máxima do veículo de carga 4: " + carga4.calcVel(carga4.getVelocMax()) + " cm/h.");
        System.out.println("Carga máxima do veículo de carga 5: " + carga5.calcVel(carga5.getVelocMax()) + " cm/h.");
    }
}
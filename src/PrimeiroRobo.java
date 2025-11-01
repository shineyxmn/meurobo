package robocode;

import robocode.*;
import java.awt.Color;

/**
 * Um robô simples de exemplo para testes do pipeline.
 */
public class PrimeiroRobo extends Robot {

    @Override
    public void run() {
        // Configura cores
        setBodyColor(Color.GREEN);
        setGunColor(Color.BLACK);
        setRadarColor(Color.GRAY);

        // Loop principal do robô
        while (true) {
            ahead(100);    // anda pra frente
            turnGunRight(360); // gira o canhão
            back(100);     // anda pra trás
            turnGunRight(360);
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent e) {
        // Atira quando vê outro robô
        fire(1);
    }

    @Override
    public void onHitByBullet(HitByBulletEvent e) {
        // Gira pra tentar escapar
        turnRight(90 - e.getBearing());
    }
}


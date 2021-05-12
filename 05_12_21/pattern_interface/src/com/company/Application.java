package com.company;

import com.company.autos.*;
import com.company.autos.strategis.*;

public class Application {

    public static void main(String[] args) {

        FillStrategy benzineFill = new BenzineFillStrategy();
        Auto sedan = new Sedan(benzineFill);

        FillStrategy dieselFill = new DieselFillsStrategy();
        Auto sedanDiesel = new Sedan(dieselFill);

        Auto truck = new Truck(dieselFill);

        sedan.fill();
        sedanDiesel.fill();
        truck.fill();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.Machine;
import java.util.Date;
import service.MachineService;
import util.HibernateUtil;

/**
 *
 * @author a
 */
public class Test {

    public static void main(String[] args) {
     /*   Machine m1 = new Machine("HP", "EE32", new Date(), 2000);
        Machine m2 = new Machine("DELL", "EEDR2", new Date(), 3000);
       */ MachineService ms = new MachineService();
      /*  ms.create(m1);
        ms.create(m2);
       */
   /*    Machine m = ms.findById(1);
        System.out.println(m.getMarque());
      */ 
      for(Machine m :ms.findAll())
            System.out.println(m.getMarque());
    }
}

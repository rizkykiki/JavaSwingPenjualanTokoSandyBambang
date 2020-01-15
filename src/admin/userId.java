/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.util.UUID;

/**
 *
 * @author pc
 */
public class userId {
          public userId()
    {}
    
    public String userDataId() 
    {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
         int randomUUIDString1 = uuid.variant();
        return randomUUIDString;
    }
      public static int userDataId1() 
    {
          UUID uuid = UUID.randomUUID();
          int randomUUIDString = uuid.clockSequence();
           return randomUUIDString;
    }
}



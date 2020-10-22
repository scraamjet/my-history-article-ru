package models;

import java.util.UUID;

 class IDGenerator {
      static Long generate(){
        UUID uuid = UUID.randomUUID();
        return uuid.getMostSignificantBits();
    }
}

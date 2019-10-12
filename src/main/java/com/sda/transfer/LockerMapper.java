package com.sda.transfer;

import com.sda.dto.LockerDTO;
import com.sda.entities.Locker;

public class LockerMapper {
    public LockerDTO convertLockerToLockerDTO(Locker locker){
        LockerDTO lockerDTO = new LockerDTO();
        lockerDTO.setNumber(locker.getNumber());
        return lockerDTO;
    }

    public Locker convertLockerDTOToLocker(LockerDTO lockerDTO){
        Locker locker = new Locker();
        return null;
    }
}

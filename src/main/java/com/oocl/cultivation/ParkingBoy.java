package com.oocl.cultivation;

public class ParkingBoy {
    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        // TODO: Please implement the method

        if(car != null && (parkingLot.getAvailableParkingPosition() < 0)) {
            ParkingTicket parkingTicket = new ParkingTicket();
            parkingLot.getCars().put(parkingTicket, car);
            this.lastErrorMessage = null;
            return parkingTicket;
        }else if ((parkingLot.getAvailableParkingPosition() >= 0)){
            this.lastErrorMessage = "The parking lot is full.";
            return null;
        }
        else{
            return null;
        }
    }
    public Car fetch(ParkingTicket ticket) {
        // TODO: Please implement the method
        if(ticket != null && parkingLot.getCars().get(ticket) != null){

            Car car = parkingLot.getCars().get(ticket);
            parkingLot.getCars().remove(ticket);
            this.lastErrorMessage = null;
            return car;
        }else if(ticket == null){
            this.lastErrorMessage = "Please provide your parking ticket.";
            return null;
        }else if(ticket != null && parkingLot.getCars().get(ticket) == null){
            this.lastErrorMessage = "Unrecognized parking ticket.";
            return null;
        }else{
            return null;
        }
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}

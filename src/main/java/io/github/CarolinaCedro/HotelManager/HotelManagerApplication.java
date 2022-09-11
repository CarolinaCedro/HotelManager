package io.github.CarolinaCedro.HotelManager;

import io.github.CarolinaCedro.HotelManager.domain.entities.Guest;
import io.github.CarolinaCedro.HotelManager.domain.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HotelManagerApplication implements CommandLineRunner {

	@Autowired
	private GuestRepository guestRepository;

	public static void main(String[] args) {
		SpringApplication.run(HotelManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Guest guest1 = new Guest("Ana",233,"Avenida",1);
		Guest guest2 = new Guest("Bela",233,"Avenida",1);
		Guest guest3 = new Guest("Sad",233,"Avenida",1);
		Guest guest4 = new Guest("Day",233,"Avenida",1);
		Guest guest5 = new Guest("Peace",233,"Avenida",1);
		Guest guest6 = new Guest("Number",233,"Avenida",1);

		guestRepository.saveAll(Arrays.asList(guest1,guest2,guest3,guest4,guest5,guest6));

	}


//private Integer Id;
//    private String Name;
//    private Integer PhoneNo;
//    private String Address;
//    private Integer RoomNo;

}

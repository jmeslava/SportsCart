package com.fdm.setup;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import com.fdm.dal.BallRepository;
import com.fdm.dal.CartRepository;
import com.fdm.dal.ItemRepository;
import com.fdm.dal.RacquetRepository;
import com.fdm.dal.ShoeRepository;
import com.fdm.models.Ball;
import com.fdm.models.Cart;
import com.fdm.models.Item;
import com.fdm.models.Racquet;
import com.fdm.models.Shoe;
import com.fdm.models.Sport;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private ItemRepository itemRepo;

	@Autowired
	private BallRepository ballRepo;

	@Autowired
	private ShoeRepository shoeRepo;

	@Autowired
	private RacquetRepository racquetRepo;
	
	
	@Autowired
	private CartRepository cartRepo;



	@Override
	@Transactional
	@Modifying
	public void run(ApplicationArguments args) throws Exception {
		Item tennisBall = new Ball("", "Dunlop Tennis Ball", "A tennis ball", 5.99, Sport.TENNIS);
		Item tennisRacquet = new Racquet("" , "Babolat Racquet", "A high quality racquet", 59.99, Sport.TENNIS);
		Item tennisShoe = new Shoe("", "Dunlop Shoes", "A decent shoe", 79.99, Sport.TENNIS);
		
		Item basketballShoe = new Shoe("", "Adidas Dame 5", "A good Basketball Shoe", 219.99, Sport.BASKETBALL);
		Item basketball = new Ball("", "Dunlop", "A Standard Basketball", 59.99, Sport.BASKETBALL);
		
		Item squashBall = new Ball("", "Dunlop Squash ball", "a small black squash ball", 3.99, Sport.SQUASH);
		Item squashRacquet = new Racquet("", "Prince racquet", "A good quality squash racquet", 69.99, Sport.SQUASH);
		
		Cart cart = new Cart();

		itemRepo.save(tennisBall);
		itemRepo.save(tennisRacquet);
		itemRepo.save(tennisShoe);
		
		itemRepo.save(basketball);
		itemRepo.save(basketballShoe);
		
		itemRepo.save(squashBall);
		itemRepo.save(squashRacquet);
		
		cartRepo.save(cart);

	}
}

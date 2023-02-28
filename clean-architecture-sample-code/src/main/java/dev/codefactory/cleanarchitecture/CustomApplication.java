package dev.codefactory.cleanarchitecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomApplication.class, args);
	}


//	@Component
//	public static class StartupListener implements ApplicationListener<ContextRefreshedEvent> {
//
//		private final ShoppingCartRepository shoppingCartRepository;
//
//		public StartupListener(ShoppingCartRepository shoppingCartRepository) {
//			this.shoppingCartRepository = shoppingCartRepository;
//		}
//
//
//		@Override
//		public void onApplicationEvent(ContextRefreshedEvent event) {
//			shoppingCartRepository.create(new ShoppingCart(null, "Test"));
//		}
//	}
}

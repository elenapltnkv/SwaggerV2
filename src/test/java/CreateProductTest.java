import Dto.CategoryType;
import Dto.Product;
import Service.CategoryService;
import Service.ProductService;
import com.github.javafaker.Faker;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import util.RetrofitUtils;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateProductTest {
    static Retrofit client;
    static ProductService productService;
    static CategoryService categoryService;
    Faker faker = new Faker();
    Product product;

    @BeforeAll
    static void beforeAll() {
        client = RetrofitUtils.getRetrofit();
        productService = client.create(ProductService.class);
        categoryService = client.create(CategoryService.class);
    }

    /*@BeforeEach
    void setUp() {
        product = new Product()
                .withTitle(faker.food())
                .withPrice((int) ((Math.random() + 1) * 100))
                .withCategoryTitle(CategoryType.FOOD.getTitle());
    }*/

    @Test
    void postProductTest() throws IOException {
        Response<Product> response = productService.createProduct(product).execute();

    }

    @Test
    void getCategoryByIdTest() throws IOException {
        Integer id = CategoryType.FOOD.getId();
        Response<ResponseBody> response = categoryService
                .getCategory(id)
                .execute();
//        log.info(response.body().toString());

    }
}
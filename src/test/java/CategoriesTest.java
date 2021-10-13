import Dto.CategoryType;
import Service.CategoryService;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CategoriesTest {
    static Retrofit retrofit;
    static CategoryService categoryService;

    @BeforeAll
    static void beforeAll() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://80.78.248.82:8189/market/api/v1/")
                //.addConverterFactory(JacksonConverterFactory.create())
                .build();
categoryService = retrofit.create(CategoryService.class);
    }

    @Test
    void getFoodCategoryTest() throws IOException {
                 Response<ResponseBody> response = categoryService
                            .getCategory(1)
                            .execute();
        //System.out.println(response.body().string());
        assertThat(response.isSuccessful());
    }
    @Test
    void getCategoryByIdTest() throws IOException {
        Integer id = CategoryType.FOOD.getId();
        Response<ResponseBody> response = categoryService
                .getCategory(3)
                .execute();
        System.out.println(response.body().string());
//        log.info(response.body().toString());
        assertThat(response.isSuccessful());
    }

}

package com.example.Gitaar.Webshop.controller;


import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/sql/create-products-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/sql/create-products-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ProductControllerTest {
/*
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    private ProductSearchRequestDto filter;
    private GraphQLRequestDto graphQLRequestDto;

    @Before
    public void init() {
        List<Integer> prices = new ArrayList<>();
        List<String> creators = new ArrayList<>();
        creators.add(CREATORS_CHANEL);

        filter = new ProductSearchRequestDto();
        filter.setCreators(creators);
        filter.setPrices(prices);

        graphQLRequestDto = new GraphQLRequestDto();
    }

    @Test
    public void getAllProducts() throws Exception {
        mockMvc.perform(get(URL_PRODUCTS_BASIC))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id").exists())
                .andExpect(jsonPath("$[*].productTitle").exists())
                .andExpect(jsonPath("$[*].creator").exists())
                .andExpect(jsonPath("$[*].year").exists())
                .andExpect(jsonPath("$[*].country").exists())
                .andExpect(jsonPath("$[*].fragranceTopNotes").exists())
                .andExpect(jsonPath("$[*].fragranceMiddleNotes").exists())
                .andExpect(jsonPath("$[*].fragranceBaseNotes").exists())
                .andExpect(jsonPath("$[*].description").exists())
                .andExpect(jsonPath("$[*].filename").exists())
                .andExpect(jsonPath("$[*].price").exists())
                .andExpect(jsonPath("$[*].color").exists())
                .andExpect(jsonPath("$[*].type").exists())
                .andExpect(jsonPath("$[*].reviews[*]", iterableWithSize(greaterThan(1))))
                .andExpect(jsonPath("$[*].reviews[*].author").isNotEmpty());
    }

    @Test
    public void getProduct() throws Exception {
        mockMvc.perform(get(URL_PRODUCTS_BASIC + "/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(2)))
                .andExpect(jsonPath("$.productTitle", equalTo("")))
                .andExpect(jsonPath("$.creator", equalTo("")))
                .andExpect(jsonPath("$.country", equalTo("")));
    }

    @Test
    public void findProductsByFilterParams() throws Exception {
        mockMvc.perform(post(URL_PRODUCTS_SEARCH)
                .content(mapper.writeValueAsString(filter))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id").isNotEmpty())
                .andExpect(jsonPath("$[*].perfumeTitle").isNotEmpty())
                .andExpect(jsonPath("$[*].perfumer").isNotEmpty())
                .andExpect(jsonPath("$[*].year").isNotEmpty())
                .andExpect(jsonPath("$[*].country").isNotEmpty())
                .andExpect(jsonPath("$[*].perfumeGender").isNotEmpty())
                .andExpect(jsonPath("$[*].fragranceTopNotes").isNotEmpty())
                .andExpect(jsonPath("$[*].fragranceMiddleNotes").isNotEmpty())
                .andExpect(jsonPath("$[*].fragranceBaseNotes").isNotEmpty())
                .andExpect(jsonPath("$[*].description").isNotEmpty())
                .andExpect(jsonPath("$[*].filename").isNotEmpty())
                .andExpect(jsonPath("$[*].price").isNotEmpty())
                .andExpect(jsonPath("$[*].volume").isNotEmpty())
                .andExpect(jsonPath("$[*].type").isNotEmpty());
    }


    @Test
    public void findByCreator() throws Exception {
        ProductSearchRequestDto filter = new ProductSearchRequestDto();
        filter.setCreator(CREATOR_CHANEL);

        mockMvc.perform(post(URL_PRODUCTS_SEARCH + "/creator")
                .content(mapper.writeValueAsString(filter))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id").isNotEmpty())
                .andExpect(jsonPath("$[*].productTitle").isNotEmpty())
                .andExpect(jsonPath("$[*].creator").isNotEmpty())
                .andExpect(jsonPath("$[*].year").isNotEmpty())
                .andExpect(jsonPath("$[*].country").isNotEmpty())
                .andExpect(jsonPath("$[*].fragranceTopNotes").isNotEmpty())
                .andExpect(jsonPath("$[*].fragranceMiddleNotes").isNotEmpty())
                .andExpect(jsonPath("$[*].fragranceBaseNotes").isNotEmpty())
                .andExpect(jsonPath("$[*].description").isNotEmpty())
                .andExpect(jsonPath("$[*].filename").isNotEmpty())
                .andExpect(jsonPath("$[*].price").isNotEmpty())
                .andExpect(jsonPath("$[*].color").isNotEmpty())
                .andExpect(jsonPath("$[*].type").isNotEmpty());
    }

    @Test
    public void getAllProductsByQuery() throws Exception {
        graphQLRequestDto.setQuery(GRAPHQL_QUERY_PRODUCTS);

        mockMvc.perform(post(URL_PRODUCTS_GRAPHQL + "/products")
                .content(mapper.writeValueAsString(graphQLRequestDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.products[*].id").isNotEmpty())
                .andExpect(jsonPath("$.data.products[*].productTitle").isNotEmpty())
                .andExpect(jsonPath("$.data.products[*].creator").isNotEmpty())
                .andExpect(jsonPath("$.data.products[*].price").isNotEmpty())
                .andExpect(jsonPath("$.data.products[*].filename").isNotEmpty());
    }

    @Test
    public void getProductByQuery() throws Exception {
        graphQLRequestDto.setQuery(GRAPHQL_QUERY_PRODUCT);

        mockMvc.perform(post(URL_PRODUCTS_GRAPHQL + "/product")
                .content(mapper.writeValueAsString(graphQLRequestDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.product.id", equalTo(2)))
                .andExpect(jsonPath("$.data.product.productTitle", equalTo("")))
                .andExpect(jsonPath("$.data.product.creator", equalTo("")))
                .andExpect(jsonPath("$.data.product.price", equalTo(35)));
    }

*/
}

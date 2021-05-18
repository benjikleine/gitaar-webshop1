package com.example.Gitaar.Webshop.service.Impl;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceImplTest {
/*
    @Autowired
    private ProductServiceImpl productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void findProductById() {
        Product product = new Product();
        product.setId(123L);

        when(productRepository.findById(123L)).thenReturn(java.util.Optional.of(product));
        productService.findProductById(123L);
        assertEquals(123L, product.getId());
        assertNotEquals(1L, product.getId());
        verify(productRepository, times(1)).findById(123L);
    }

    @Test
    public void findAllProduct() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());
        productList.add(new Product());

        when(productRepository.findAll()).thenReturn(productList);
        productService.findAllProducts();
        assertEquals(2, productList.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void filter() {
        Product productChanel = new Product();
        productChanel.setCreator(CREATOR_CHANEL);
        Product productCreed = new Product();
        productCreed.setCreator(CREATOR_CREED);

        List<Product> productList = new ArrayList<>();
        productList.add(productChanel);
        productList.add(productChanel);

        List<String> creators = new ArrayList<>();
        creators.add(CREATOR_CHANEL);
        creators.add(CREATOR_CREED);
    }

    @Test
    public void findByCreatorOrderByPriceDesc() {
        Product productChanel = new Product();
        productChanel.setCreator(CREATOR_CHANEL);
        Product productCreed = new Product();
        productCreed.setCreator(CREATOR_CREED);
        List<Product> productList = new ArrayList<>();
        productList.add(productChanel);
        productList.add(productCreed);

        when(productRepository.findByCreatorOrderByPriceDesc(CREATOR_CHANEL)).thenReturn(productList);
        productService.findByCreatorOrderByPriceDesc(CREATOR_CHANEL);
        assertEquals(productList.get(0).getCreator(), CREATOR_CHANEL);
        assertNotEquals(productList.get(0).getCreator(), CREATOR_CREED);
        verify(productRepository, times(1)).findByCreatorOrderByPriceDesc(CREATOR_CHANEL);
    }

    @Test
    public void saveProduct() {

        MultipartFile multipartFile = new MockMultipartFile(FILE_NAME, "Hello World".getBytes());
        Product product = new Product();
        product.setId(1L);
        product.setCreator(CREATOR_CHANEL);
        product.setFilename(multipartFile.getOriginalFilename());

        when(productRepository.save(product)).thenReturn(product);
        productService.saveProduct(product, multipartFile);
        verify(productRepository, times(1)).save(product);
    }

 */
}

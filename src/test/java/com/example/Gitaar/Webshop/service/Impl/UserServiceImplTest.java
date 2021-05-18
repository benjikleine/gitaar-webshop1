package com.example.Gitaar.Webshop.service.Impl;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
/*
    @Autowired
    private UserServiceImpl userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    ProductRepository productRepository;

    @MockBean
    private ReviewRepository reviewRepository;

    @MockBean
    private JwtProvider jwtProvider;

    @MockBean
    private MailSender mailSender;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    public void findUserByID() {
        User user = new User();
        user.setId(122L);

        when(userRepository.findById(122L)).thenReturn(java.util.Optional.of(user));
        userService.findUserById(122L);
        assertEquals(122L, user.getId());
        verify(userRepository, times(1)).findById(122L);
    }

    @Test
    public void findUserByEmail() {
        User user = new User();
        user.setEmail(USER_EMAIL);
        userService.findUserByEmail(USER_EMAIL);

        when(userRepository.findByEmail(USER_EMAIL)).thenReturn(user);
        assertEquals(USER_EMAIL, user.getEmail());
        verify(userRepository, times(1)).findByEmail(USER_EMAIL);
    }

    @Test
    public void findAllUsers() {
        List<User> usersList = new ArrayList<>();
        usersList.add(new User());
        usersList.add(new User());
        userService.findAllUsers();

        when(userRepository.findAll()).thenReturn(usersList);
        assertEquals(2, usersList.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void findByPasswordResetCode() {
        User user = new User();
        user.setPasswordResetCode(USER_PASSWORD_RESET_CODE);
        userService.findByPasswordResetCode(USER_PASSWORD_RESET_CODE);

        when(userRepository.findByPasswordResetCode(USER_PASSWORD_RESET_CODE)).thenReturn(user);
        assertEquals(USER_PASSWORD_RESET_CODE, user.getPasswordResetCode());
        verify(userRepository, times(1)).findByPasswordResetCode(USER_PASSWORD_RESET_CODE);
    }

    @Test
    public void getCart() {
        List<Long> productIds = new ArrayList<>(Arrays.asList(2L, 4L));
        Product firstProduct = new Product();
        firstProduct.setId(2L);
        Product secondProduct = new Product();
        secondProduct.setId(4L);
        List<Product> productList = new ArrayList<>(Arrays.asList(firstProduct, secondProduct));
        userService.getCart(productIds);

        when(productRepository.findByIdIn(productIds)).thenReturn(productList);
        assertEquals(2, productList.size());
        assertEquals(2, productIds.size());
        assertNotNull(productList);
        verify(productRepository, times(1)).findByIdIn(productIds);
    }

    @Test
    public void login() {
        User user = new User();
        user.setId(123L);
        user.setEmail(USER_EMAIL);
        user.setActive(true);
        user.setFirstName(FIRST_NAME);
        user.setRoles(Collections.singleton(Role.USER));

        when(userRepository.findByEmail(USER_EMAIL)).thenReturn(user);
        assertEquals(123L, user.getId());
        assertEquals(USER_EMAIL, user.getEmail());
        assertEquals(FIRST_NAME, user.getFirstName());
        userService.login(USER_EMAIL);
        verify(userRepository, times(1)).findByEmail(user.getEmail());
        verify(jwtProvider, times(1)).createToken(user.getEmail(), user.getRoles().iterator().next().name());
    }

    @Test
    public void loadUserByUsername() {
        User user = new User();
        user.setEmail(USER_EMAIL);
        user.setActive(true);
        user.setFirstName(FIRST_NAME);
        user.setRoles(Collections.singleton(Role.USER));

        when(userRepository.findByEmail(USER_EMAIL)).thenReturn(user);
        assertEquals(USER_EMAIL, user.getEmail());
        assertEquals(FIRST_NAME, user.getFirstName());
        assertTrue(user.isActive());
    }

    @Test
    public void registerUser() {
        User user = new User();
        user.setEmail(USER_EMAIL);
        boolean isUserCreated = userService.registerUser(user);

        assertTrue(isUserCreated);
        assertNotNull(user.getActivationCode());
        assertTrue(CoreMatchers.is(user.getRoles()).matches(Collections.singleton(Role.USER)));
        verify(userRepository, times(1)).save(user);
        verify(mailSender, times(1))
                .send(
                        ArgumentMatchers.eq(user.getEmail()),
                        ArgumentMatchers.eq("Activation code"),
                        ArgumentMatchers.anyString());
    }

    @Test
    public void registerOauthUser() {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("sub", 123456);
        attributes.put("given_name", FIRST_NAME);
        attributes.put("family_name", LAST_NAME);
        attributes.put("email", USER_EMAIL);
        GoogleOAuth2UserInfo userInfo = new GoogleOAuth2UserInfo(attributes);

        User user = new User();
        user.setEmail(USER_EMAIL);
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setProvider(AuthProvider.GOOGLE);

        when(userRepository.save(user)).thenReturn(user);
        userService.registerOauth2User("google", userInfo);
        assertEquals(USER_EMAIL, user.getEmail());
        assertEquals(FIRST_NAME, user.getFirstName());
        assertEquals(LAST_NAME, user.getLastName());
        assertNull(user.getPassword());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void updateOauthUser() {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("sub", 123456);
        attributes.put("given_name", FIRST_NAME);
        attributes.put("family_name", LAST_NAME);
        attributes.put("email", USER_EMAIL);
        GoogleOAuth2UserInfo userInfo = new GoogleOAuth2UserInfo(attributes);

        User user = new User();
        user.setEmail(USER_EMAIL);
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setProvider(AuthProvider.GOOGLE);

        when(userRepository.save(user)).thenReturn(user);
        userService.updateOauth2User(user, "google", userInfo);
        assertEquals(USER_EMAIL, user.getEmail());
        assertEquals(FIRST_NAME, user.getFirstName());
        assertEquals(LAST_NAME, user.getLastName());
        assertEquals(AuthProvider.GOOGLE, user.getProvider());
        assertNull(user.getPassword());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void sendPasswordResetCode() {
        User user = new User();
        user.setEmail(USER_EMAIL);
        user.setPasswordResetCode(USER_PASSWORD_RESET_CODE);

        when(userRepository.save(user)).thenReturn(user);
        when(userRepository.findByEmail(USER_EMAIL)).thenReturn(user);
        userService.sendPasswordResetCode(USER_EMAIL);
        assertEquals(USER_EMAIL, user.getEmail());
        assertNotNull(user.getPasswordResetCode());
        verify(userRepository, times(1)).save(user);
        verify(userRepository, times(1)).findByEmail(user.getEmail());
        verify(mailSender, times(1))
                .send(
                        ArgumentMatchers.eq(user.getEmail()),
                        ArgumentMatchers.eq("Password reset"),
                        ArgumentMatchers.anyString());
    }

    @Test
    public void passwordReset() {
        User user = new User();
        user.setEmail(USER_EMAIL);
        user.setPassword(USER_PASSWORD);

        when(userRepository.findByEmail(USER_EMAIL)).thenReturn(user);
        when(passwordEncoder.encode(USER_PASSWORD)).thenReturn(user.getPassword());
        when(userRepository.save(user)).thenReturn(user);
        userService.passwordReset(user.getEmail(), user.getPassword());
        assertEquals(USER_EMAIL, user.getEmail());
        assertNotNull(user.getPassword());
        verify(userRepository, times(1)).findByEmail(user.getEmail());
        verify(passwordEncoder, times(1)).encode(user.getPassword());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void activateUser() {
        User user = new User();
        user.setActivationCode(USER_ACTIVATION_CODE);

        when(userRepository.findByActivationCode(USER_ACTIVATION_CODE)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        boolean isActivated = userService.activateUser(user.getActivationCode());
        assertTrue(isActivated);
        assertNull(user.getActivationCode());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void updateProfile() {
        User user = new User();
        user.setEmail(USER_EMAIL);
        user.setFirstName(FIRST_NAME);

        when(userRepository.findByEmail(USER_EMAIL)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        userService.updateProfile(USER_EMAIL, user);
        assertEquals(USER_EMAIL, user.getEmail());
        assertEquals(FIRST_NAME, user.getFirstName());
        verify(userRepository, times(1)).findByEmail(user.getEmail());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void addReviewToProduct() {
        List<Review> reviewList = new ArrayList<>();
        Review review = new Review();
        reviewList.add(review);
        Product product = new Product();
        product.setId(123L);
        product.setReviews(reviewList);

        when(productRepository.getOne(123L)).thenReturn(product);
        when(reviewRepository.save(review)).thenReturn(review);
        userService.addReviewToProduct(review, 123L);
        assertEquals(123L, product.getId());
        assertNotNull(product.getReviews());
        verify(productRepository, times(1)).getOne(123L);
        verify(reviewRepository, times(1)).save(review);
    }

 */
}
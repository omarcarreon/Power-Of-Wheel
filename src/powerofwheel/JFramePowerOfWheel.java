/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powerofwheel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import javax.swing.JFrame;
import java.util.Timer;


/**
 * @author Omar Carreon, Diego Aleman, Gabriel Salazar, Carlos Santiago
 */





public class JFramePowerOfWheel extends JFrame implements Runnable, 
        MouseListener, KeyListener{
    private Graphics graGraficaApplet; // Objeto grafico de la Imagen
    private Image imaImagenApplet;     // objeto de la clase Image  
    private SoundClip souSoundtrack;      // Objeto SoundClip de soundtrack
    

    private Image imaBootLogo;      // imagen de boot con logo
    private boolean bBootLogo;      // boolena para mostrar boot con logo
    private int iContBootLogo;      // contador para mostrar boot con logo
    
    
    private boolean nivel2;         // booleana para nivel de noche
    
   private int iVelocidadJuego;     // velocidad del juego
    
    private Base basCalle;      // Objeto de la calle
    private Base basCalle2;     // objeto de la calle 2
    private Personaje perPersonaje;     // objeto de la clase personaje
    
    
    private boolean bPintaCalle; // Booleano para pintar calle1
    private boolean bPintaCalle2; // Booleano para pintar calle2
    private boolean bPintaLogin;    // booleana para pintar logo
    private Image imaImagenBoot;    // imagen de boot
    private Base basEdificios;      // objeto de edificios 1
    private Base basEdificios2;     // objeto de edificios 2
    private boolean bPintaEdificios; // booleano para pintar edificios 1
    private boolean bPintaEdificios2; // boleano para pintar edificios 2
    
    
    
    
    
    /*
    *   SALTO
    */
    private int iVelocidadY;    // velocidad en Y para el salto
    private int iGravedad;  // gravedad para el salto
    private boolean bTocandoSuelo;  // se prende si esta tocando el suelo
    private boolean bSalto; // si el usuario presiona espacio y quiere saltar
    private int iContAlturaSalto; // contador para controlar la altura del salto
    private boolean bCargandoSalto; // booleana para cargar la altura del salto
   
    
    
    
    
     /*
    *   PANTALLAS
    */
    private Image imaMenuPrincipal;     // imagen de menu principal
    private boolean bMenuPrincipal;     // booleana para mostrar menu principal
    
    private Image imaPantallaControles;    // imagen pantalla Controles
    private boolean bPantallaControles;     // booleana para mostrar pantalla
                                            // de Controles
    
    private Image imaPantallaCreditos;  // imagen pantalla Creditos
    private boolean bPantallaCreditos;  // booleana para mostrar pantalla de
                                        // Creditos
    
    private Image imaPantallaGameOver;  // imagen pantalla Game Over
    private boolean bPantallaGameOver;  // booleana para mostrar pantalla de 
                                        // Game Over
    
    private Image imaPantallaInstrucciones; // imagen pantalla Instrucciones
    private boolean bPantallaInstrucciones; // booleana para mostrar pantalla 
                                            // de Instrucciones
    
    private boolean bPantallaJuego;  // booleana para mostrar pantalla del juego
    
    private boolean bPantallaSalir;     // booleana para salir del Juego
  
    
    /*
    * IMAGENES NIVELES
    */
    private Image imaNivel1;             // imagen de pantalla nivel 1
    private boolean bImagenNivel1;      // booleana para imagen de nivel1
    private Image imaNivel2;            // imagen de pantalla nivel 2
    private boolean bImagenNivel2;      // booleana para imagen de nivel2
    
    
    /*
    *   BOTONES
    */
    private Base basBotonJugar;         // objeto boton Jugar
    private Base basBotonInstrucciones; // objeto boton Instrucciones
    private Base basBotonControles;     // objeto boton Controles
    private Base basBotonCreditos;      // objeto boton Creditos
    private Base basBotonSalir;         // objeto boton Salir
    private Base basBotonJugar2;        // objeto boton Jugar 2
    private Base basBotonRegresar2;     // objeto boton Regresar 2
    private Base basBotonVolverAJugar;  // objeto boton volver a jugar
    private Base basBotonRegresarAMenu; // objeto boton regresar a menu
    private Base basBotonSalir2;        // objeto boton salir desde pausa

    
    /*
    *   ANIMACIONES
    */
    private Animacion animAvanzando;    // animacion personaje avanzando
    private Animacion animDano;         // animacion personaje daño
    private Animacion animSaltando;     // animacion personaje saltando
    private Animacion animBurlandose;   // animacion obstaculo burlandose
    private Animacion animPerro;        // animacion obstaculo perro
    private Animacion animHoverChair;        // animacion powerup hoverchair
    private boolean bAvanzando;     // booleana para personaje avanzando
    //Variables de control de tiempo de la animación
    private long tiempoActual;          // tiempo actual del jframe
    private long tiempoInicial;             // tiempo inicial de jframe
    int posX, posY;                 // posiciones x y y de animaciones
        
    
    /*
    *   OBSTACULOS
    */
    
    private Base basCarro1;             // objeto del carro 1
    private boolean bCarro1;            // booleana para manejar carro 1
    private Base basCarro2;             // objeto del carro 2
    private boolean bCarro2;            // booleana para manejar carro 2
    private int contObjetos;            // contador de objetos
    private int iSeleccionObstaculo;     // iSeleccionObstaculo de objetos 
    private Base basPicos;              // objeto de picos
    private boolean bPicos;             // booleana para manejar picos
    private Base basPicos2;              // objeto de picos 2
    private boolean bPicos2;             // booleana para manejar picos 2
    private Base basBasura;             // objeto de bote de basura
    private boolean bBasura;            // booleana para objeto bote de basura
    private boolean bColision;          // booleana para colision
    private Base basPerro;              // objeto de un perro
    private boolean bPerro;            // booleana para manejar objeto perro
    /*
    *   SCORE
    */
    private int iVidas;             // numero de vidas
    private int iPuntaje;           // puntaje
    private Base basVida1;          // objeto de 1 vida
    private Base basVida2;          // objeto de 2 vidas
    private Base basVida3;          // objeto de 3 vidas
    private Base basPuntaje;            // objeto de puntaje
    
    
    
    /*
    *   PAUSA
    */
    private Base basPausa;          // objeto de pantalla pausa
    private boolean bPausa;           // booleana para controlar pantalla pausa
    private Base basPausaContinuar;     // objeto de quitar pausa
    private Base basPausaMenuPrincipal; // objeto de regresar menu principal
    private Base basPausaRegresar;      // objeto regresar de pausa
    private Base basPausaSalir;         // objeto salir del juego
    
    
    /*
    *   SONIDO
    */
    private SoundClip souSonidoFondo;      // objeto de clase soundclip: fondo
    private SoundClip souColision;       // objeto de clase soundclip: colision
    private SoundClip souPowerUp;         // objeto de clase soundclip: powerup
    
    /*
    *   POWERUPS
    */
    private Base basHoverChair;         // objeto para powerup hover chair
    private boolean bHoverChair;        // boolena para powerup hover chair
    private boolean bActivaHoverChair;  // boolena para activar hover chair
    private int iAuxPuntaje;            // determina duración de hover chair
    private int random;             // random para conteo de powerup
    
    /**
     * Método constructor de la clase <code>JFramePrototipoAlpha1</code>.
     */
    public JFramePowerOfWheel() {
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        start();
    }  
    
    /**
     * Metodo <I>init</I> sobrescrito de la clase <code>Applet</code>.<P>
     * En este metodo se inizializan las variables o se crean los objetos a
     * usarse en el <code>Applet</code> y se definen funcionalidades.
     */
    public void init() {
        // creo el sonido de soundtrack
       // souSoundtrack = new SoundClip("soundtrack.wav");
        //souSoundtrack.play();
        // inicializa velocidad del juego
        iVelocidadJuego = 13;
        // se crea imagen de Boot con Logo
        imaBootLogo = Toolkit.getDefaultToolkit()
                .getImage(this.getClass().getResource("Inicio.png")); 
        // inicializa booleana para mostrar Menu Principal
        bBootLogo = false;
        iContBootLogo = 12000;
        // se crea imagen de calle 1
        URL urlImagenCalle= this.getClass().getResource("Calle.jpg"); 
        // se crea la Calle 1
	basCalle = new Base(0, 0,
                Toolkit.getDefaultToolkit().getImage(urlImagenCalle));
        // inicializa posicion de la calle
        basCalle.setX(0);
        basCalle.setY(450);
        // se crea imagen de calle 2
        URL urlImagenCalle2= this.getClass().getResource("Calle.jpg"); 
        // se crea la Calle 2
	basCalle2 = new Base(0, 0,
                Toolkit.getDefaultToolkit().getImage(urlImagenCalle2));
        // inicializa posicion de la calle
        basCalle2.setX(getWidth());
        basCalle2.setY(450);        
        bPintaCalle = true;
        bPintaCalle2 = false;
        
        bPintaLogin = false;
        imaImagenBoot = Toolkit.getDefaultToolkit()
                .getImage(this.getClass().getResource("Inicio.png"));
        
        // se crea la imagen de edificios 1
        URL urlImagenEdificios1 = this.getClass().getResource("Edificios.png");
        // se crea los edificios 1
        basEdificios = new Base(0,0,
                Toolkit.getDefaultToolkit().getImage(urlImagenEdificios1));
        // inicializa posicion de los edificios 1
        basEdificios.setX(0);
        basEdificios.setY(182);
        bPintaEdificios =  true;
        bPintaEdificios2 = false;
        
        // se crea la imagen de edificios 2
        URL urlImagenEdificios2 = this.getClass().getResource("Edificios2.png");
        // se crea los edificios 1
        basEdificios2 = new Base(0,0,
                Toolkit.getDefaultToolkit().getImage(urlImagenEdificios2));
        // inicializa posicion de los edificios 1
        basEdificios2.setX(getWidth());
        basEdificios2.setY(175);   
        
        
        /*
        * NIVELES
        */
        imaNivel1 = Toolkit.getDefaultToolkit()
                .getImage(this.getClass().getResource("nivel1.png")); 
        // inicializa booleana para mostrar imagen nivel 1
        bImagenNivel1 = false;
        
        imaNivel2 = Toolkit.getDefaultToolkit()
                .getImage(this.getClass().getResource("nivel2.png")); 
        // inicializa booleana para mostrar imagen nivel 2
        bImagenNivel2 = false;
        
        nivel2 = false;

        
        
        /*
        *   CREA PERSONAJE PRINCIPAL
        */
        URL urlImagenPersonaje = this.getClass().getResource("Avanzando_1.png");
	perPersonaje = new Personaje(-100,-100, Toolkit.getDefaultToolkit().
                getImage(urlImagenPersonaje));
        perPersonaje.setX(100);
        perPersonaje.setY(400);
        
        
        
        
        /*
        *   TODO RELACIONADO CON ANIMACION
        */
        //Se cargan las imágenes(cuadros) para la animación AVANZANDO
        Image avanzando1 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                getResource("Avanzando_1.png"));
        Image avanzando2 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                getResource("Avanzando_2.png"));
        Image avanzando3 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                getResource("Avanzando_3.png"));
        Image avanzando4 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                getResource("Avanzando_4.png"));
        Image avanzando5 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                getResource("Avanzando_5.png"));
        
        //Se crea la animación AVANZANDO
        animAvanzando = new Animacion();
        animAvanzando.sumaCuadro(avanzando1, 100);
        animAvanzando.sumaCuadro(avanzando2, 100);
        animAvanzando.sumaCuadro(avanzando3, 100);
        animAvanzando.sumaCuadro(avanzando4, 100);
        animAvanzando.sumaCuadro(avanzando5, 400);
        bAvanzando = false;
        //Se cargan las imágenes(cuadros) para la animación DANO
        Image dano1 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                getResource("Dano_1.png"));
        Image dano2 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                getResource("Dano_2.png"));
        Image dano3 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                getResource("Dano_3.png"));
        Image dano4 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                getResource("Dano_4.png"));
        
        //Se crea la animación DANO
        animDano = new Animacion();
        animDano.sumaCuadro(dano1, 100);
        animDano.sumaCuadro(dano2, 100);
        animDano.sumaCuadro(dano3, 100);
        animDano.sumaCuadro(dano4, 100);
        
        //Se cargan las imágenes(cuadros) para la animación SALTANDO
        Image saltando1 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                getResource("Saltando_1.png"));
        Image saltando2 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                getResource("Saltando_2.png"));
        Image saltando3 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                getResource("Saltando_3.png"));
        Image saltando4 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                getResource("Saltando_4.png"));
        Image saltando5 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                getResource("Saltando_5.png"));
        Image saltando6 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                getResource("Saltando_6.png"));
        Image saltando7 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                getResource("Saltando_7.png"));
        Image saltando8 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                getResource("Saltando_8.png"));
        Image saltando9 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                getResource("Saltando_9.png"));
        
        //Se crea la animación CUADRO
        animSaltando = new Animacion();
        
        animSaltando.sumaCuadro(saltando1, 100);
        animSaltando.sumaCuadro(saltando2, 100);
        animSaltando.sumaCuadro(saltando3, 100);
        animSaltando.sumaCuadro(saltando4, 100);
        animSaltando.sumaCuadro(saltando5, 100);
        animSaltando.sumaCuadro(saltando6, 100);
        animSaltando.sumaCuadro(saltando7, 100);
        animSaltando.sumaCuadro(saltando8, 100);
        animSaltando.sumaCuadro(saltando9, 100);
        
   
        //Se cargan las imágenes(cuadros) para la animación BURLANDOSE
        Image burlandose1 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Burlandose_1.png"));
        Image burlandose2 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Burlandose_2.png"));
        
        //Se crea la animación BURLANDOSE
        animBurlandose = new Animacion();
        
        animBurlandose.sumaCuadro(burlandose1, 100);
        animBurlandose.sumaCuadro(burlandose2, 100);
        
        //Se cargan las imágenes(cuadros) para la animación PERRO
        Image perro1 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Perro_1.png"));
        Image perro2 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("Perro_2.png"));
        
        animPerro = new Animacion();
        
        animPerro.sumaCuadro(perro1, 100);
        animPerro.sumaCuadro(perro2, 100);
        
        
        //Se cargan las imágenes(cuadros) para la animación HOVER CHARIR
        Image hover1 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("HoverChair_1.png"));
        Image hover2 = Toolkit.getDefaultToolkit().getImage(this.getClass()
                .getResource("HoverChair_2.png"));
        
        animHoverChair = new Animacion();
        
        animHoverChair.sumaCuadro(hover1, 100);
        animHoverChair.sumaCuadro(hover2, 100);
        
  
        
        
        
        
        
        
        /*
        *   PANTALLAS
        */
        // se crea imagen de MENU PRINCIPAL
        imaMenuPrincipal = Toolkit.getDefaultToolkit()
                .getImage(this.getClass().getResource("MenuPrincipal.jpg")); 
        // inicializa booleana para mostrar Menu Principal
        bMenuPrincipal = true;
       
         // se crea imagen de CONTROLES
        imaPantallaInstrucciones = Toolkit.getDefaultToolkit()
                .getImage(this.getClass().
                        getResource("PantallaInstrucciones.jpg"));
        bPantallaInstrucciones = false;
        
        
        // se crea imagen de CONTROLES
        imaPantallaControles = Toolkit.getDefaultToolkit()
                .getImage(this.getClass().getResource("PantallaControles.jpg"));
        bPantallaControles = false;
        
        // se crea imagen de CREDITOS
        imaPantallaCreditos = Toolkit.getDefaultToolkit()
                .getImage(this.getClass().getResource("PantallaCreditos.jpg"));
        bPantallaCreditos = false;
        
        // se crea imagen de GAME OVER
        imaPantallaGameOver = Toolkit.getDefaultToolkit()
                .getImage(this.getClass().getResource("PantallaGameOver.jpg"));
        bPantallaGameOver = false;
        
        bPantallaSalir = false;
        
        // inicializa booleana para mostrar Pantalla del Juego
        bPantallaJuego = false;
        
        
        
        
        
        
        
        
        /*
        *   BOTONES
        */
        // se crea imagen de boton Jugar
        URL urlImagenBotonJugar = this.getClass().getResource("BotonJugar.png"); 
        // se crea el objeto del boton Jugar
	basBotonJugar = new Base(0, 0,
                Toolkit.getDefaultToolkit().getImage(urlImagenBotonJugar));
        basBotonJugar.setX(680);
        basBotonJugar.setY(230);
        
        // se crea imagen de boton Instrucciones
        URL urlImagenBotonInstrucciones = this.getClass().
                getResource("BotonInstrucciones.png"); 
        // se crea el objeto del boton Jugar
	basBotonInstrucciones = new Base(0, 0,
                Toolkit.getDefaultToolkit().
                        getImage(urlImagenBotonInstrucciones));
        basBotonInstrucciones.setX(680);
        basBotonInstrucciones.setY(basBotonJugar.getY() + 
                basBotonJugar.getAlto() + 5);
        
        // se crea imagen de boton Controles
        URL urlImagenBotonControles = this.getClass().getResource
        ("BotonControles.png"); 
        // se crea el objeto del boton Jugar
	basBotonControles = new Base(0, 0,
                Toolkit.getDefaultToolkit().getImage(urlImagenBotonControles));
        basBotonControles.setX(680);
        basBotonControles.setY(basBotonInstrucciones.getY() + 
                basBotonInstrucciones.getAlto() + 5);
        
        // se crea imagen de boton Creditos
        URL urlImagenBotonCreditos = this.getClass().
                getResource("BotonCreditos.png"); 
        // se crea el objeto del boton Jugar
	basBotonCreditos = new Base(0, 0,
                Toolkit.getDefaultToolkit().getImage(urlImagenBotonCreditos));
        basBotonCreditos.setX(680);
        basBotonCreditos.setY(basBotonControles.getY() + 
                basBotonControles.getAlto() + 5);
        
        // se crea imagen de boton Salir
        URL urlImagenBotonSalir = this.getClass().getResource("BotonSalir.png"); 
        // se crea el objeto del boton Jugar
	basBotonSalir = new Base(0, 0,
                Toolkit.getDefaultToolkit().getImage(urlImagenBotonSalir));
        basBotonSalir.setX(680);
        basBotonSalir.setY(basBotonCreditos.getY() + 
                basBotonCreditos.getAlto() + 5);
        
        // crea imagen boton Jugar en Pantallas Instrucciones/Controles/Créditos
        URL urlImagenBotonJugar2 = this.getClass().
                getResource("BotonJugar2.png");
        // crea objeto boton Jugar en Pantallas Instrucciones/Controles/Creditos
        basBotonJugar2 = new Base(0, 0,
                Toolkit.getDefaultToolkit().getImage(urlImagenBotonJugar2));
        basBotonJugar2.setX(930);
        basBotonJugar2.setY(500);
        
        //crea imagen boton Regresar a Menu Principal
        URL urlImagenBotonRegresar2 = this.getClass().
                getResource("BotonRegresar2.png");
        // crea objeto boton Regresar a Menu Principal
        basBotonRegresar2 = new Base(0, 0,
                Toolkit.getDefaultToolkit().getImage(urlImagenBotonRegresar2));
        basBotonRegresar2.setX(930);
        basBotonRegresar2.setY(430);        
        
        // crea imagen boton Volver a Jugar
        URL urlImagenBotonVolverAJugar = this.getClass().
                getResource("BotonVolveraJugar.png");
        // crea objeto boton Volver a Jugar
        basBotonVolverAJugar = new Base(0, 0,
                Toolkit.getDefaultToolkit().
                        getImage(urlImagenBotonVolverAJugar));
        basBotonVolverAJugar.setX(10);
        basBotonVolverAJugar.setY(500);
        
        // crea imagen boton Regresar A Menu
        URL urlImagenBotonRegresarAMenu = this.getClass().
                getResource("BotonRegresaralMenu.png");
        // crea objeto boton Volver a Jugar
        basBotonRegresarAMenu = new Base(0, 0,
                Toolkit.getDefaultToolkit().
                        getImage(urlImagenBotonRegresarAMenu));
        basBotonRegresarAMenu.setX(500);
        basBotonRegresarAMenu.setY(500);
        
        // crea imagen boton Salir desde Pausa
        URL urlImagenBotonSalir2 = this.getClass().
                getResource("BotonSalir2.png");
        // crea objeto boton Salir desde pausa
        basBotonSalir2 = new Base(0, 0,
                Toolkit.getDefaultToolkit().getImage(urlImagenBotonSalir2));
        basBotonSalir2.setX(1000);
        basBotonSalir2.setY(490);
        
        
        /*
        *   SALTO
        */
        iVelocidadY = 0;    // todavia no salta
        iGravedad = 1;  // gravedad 
        bTocandoSuelo = true;   // empieza tocando el suelo
        bSalto = false; // no ha saltado
        iContAlturaSalto = 0;           // contador de altura del salto
        bCargandoSalto = false;         // cargar salto
        
        
        
        
        
        
        
        /*
        *   OBSTACULOS
        */
        bColision = false;              // colision incializa falsa
        iSeleccionObstaculo = 1;            // seleccion de objetos a desplegar
        // imagen de carro1
        URL urlImagenCarro1 = this.getClass().getResource("Carro1.png");
        // se crea el carro 1
        basCarro1 = new Base(0,0,
                Toolkit.getDefaultToolkit().getImage(urlImagenCarro1));
        // inicializa posicion del carro 1
        basCarro1.setX(getWidth() + 10);
        basCarro1.setY(420);  
        bCarro1 = false;
        // imagen de carro 2
        URL urlImagenCarro2 = this.getClass().getResource("Carro2.png");
        // se crea el carro 2
        basCarro2 = new Base(0,0,
                Toolkit.getDefaultToolkit().getImage(urlImagenCarro2));
        // inicializa posicion de carro 2
        basCarro2.setX(getWidth() + 10);
        basCarro2.setY(430);  
        bCarro2 = false;        
        // imagen de picos
        URL urlImagenPicos = this.getClass().getResource("Picos.png");
        // se crean picos
        basPicos = new Base(0,0, Toolkit.getDefaultToolkit().
                getImage(urlImagenPicos));
        // inicializa posicion de picos
        basPicos.setX(getWidth() + 10);
        basPicos.setY(490);
        bPicos = false;
        
        // imagen de picos 2
        URL urlImagenPicos2 = this.getClass().getResource("Picos.png");
        // se crean picos 2
        basPicos2 = new Base(0,0, Toolkit.getDefaultToolkit().
                getImage(urlImagenPicos2));
        // inicializa posicion de picos 2
        basPicos2.setX(getWidth() + 100);
        basPicos2 .setY(490);
        bPicos2 = false;
           
        // imagen de bote de basura
        URL urlImagenBasura = this.getClass().getResource("basura.png");
        // se crea objeto bote de basura
        basBasura = new Base(0,0, Toolkit.getDefaultToolkit().
                getImage(urlImagenBasura));
        // inicializa posicion de bote de basura
        basBasura.setX(getWidth() + 10);
        basBasura.setY(455);
        bBasura = false;  
        contObjetos = 0;     // contador de objetos
        
        // imagen de perro
        URL urlImagenPerro = this.getClass().getResource("Perro_1.png");
        // se crea objeto de perro
        basPerro = new Base(0,0, Toolkit.getDefaultToolkit().
                getImage(urlImagenPerro));
        // inicializa posicion de perro
        basPerro.setX(getWidth() + 10);
        basPerro.setY(430);
        bPerro = false;
        
        
        
        /*
        *   SCORE Y VIDAS
        */
        iVidas = 3;
        iPuntaje = 0;
       
        // imagen de rueda (vida)
        URL urlVidas= this.getClass().getResource("Rueda.png");
        // objeto de vida 1
        basVida1 = new Base(0,0,
                Toolkit.getDefaultToolkit().getImage(urlVidas));
        // objeto de vida 2
        basVida2 = new Base(0,0,
                Toolkit.getDefaultToolkit().getImage(urlVidas));
        // objeto de vida 3
        basVida3 = new Base(0,0,
                Toolkit.getDefaultToolkit().getImage(urlVidas));
        
        
        
        /*
        *   PAUSA
        */
        // se crean objetos de pantalla de pausa
        URL urlPausa =  this.getClass().getResource("Pausa.png");
        basPausa = new Base(0,0,
                Toolkit.getDefaultToolkit().getImage(urlPausa));
        bPausa = false;
        
        // se crea imagen de boton continuar 
        URL urlPausaContinuar = this.getClass().
                getResource("PausaContinuar.png");
        // crea objeto de boton de continuar 
        basPausaContinuar = new Base(0,0,
                Toolkit.getDefaultToolkit().getImage(urlPausaContinuar));
        // inicializa posicion de boton de continuar 
        basPausaContinuar.setX(getWidth()/2 - 100);
        basPausaContinuar.setY(180);
        
        // crea imagen de boton menu principal
        URL urlPausaMenuPrincipal = this.getClass().
                getResource("PausaMenuPrincipal.png");
        // crea objeto de boton menu principl
        basPausaMenuPrincipal = new Base(0,0,
                Toolkit.getDefaultToolkit().getImage(urlPausaMenuPrincipal));
        // iniciliza posicion de boton menu principal
        basPausaMenuPrincipal.setX(getWidth()/2 - 100);
        basPausaMenuPrincipal.setY(280);
        
        // crea imagen de boton regresar
        URL urlPausaRegresar = this.getClass().getResource("PausaRegresar.png");
        // crea obetjo de boton regresar
        basPausaRegresar = new Base(0,0,
                Toolkit.getDefaultToolkit().getImage(urlPausaRegresar));
        // inicializa posicion de boton menu principal
        basPausaRegresar.setX(getWidth()/2 - 100);
        basPausaRegresar.setY(370);
        // crea iamgen de boton salir
        URL urlPausaSalir = this.getClass().getResource("PausaSalir.png");
        // crea objeto de boton salir
        basPausaSalir = new Base(0,0,
                Toolkit.getDefaultToolkit().getImage(urlPausaSalir));
        // inicializa posicion de boton salir
        basPausaSalir.setX(getWidth()/2 - 100);
        basPausaSalir.setY(450);
        
        /*
        *   SONIDO
        */
//<<<<<<< HEAD

        souSonidoFondo = new SoundClip("Musica.wav");       // sonido de fondo
        souSonidoFondo.play();              // reproduce sonido de fondo
        
        souColision = new SoundClip("sonidoColision.wav");   // sonido colision
        
        souPowerUp = new SoundClip("sonidoPowerUp.wav");    // sonido powerup
       
        
        /*
        *   POWERUP
        */
        // crea imagen de powerup hover chair
        URL urlPowerupHoverChair = this.getClass()
                .getResource("hoverchair.png");
        // crea objeto de powerup hover chair
        basHoverChair = new Base(0,0,
                Toolkit.getDefaultToolkit().getImage(urlPowerupHoverChair));
        // inicializa posicion de power up hover chair
        basHoverChair.setX(getWidth() + 50);
        basHoverChair.setY(200);
        bActivaHoverChair = false;  // inicializa en falso activacion powerup
        iAuxPuntaje = 0;            // auxiliar para puntaje
        random = (int)(Math.random() * 3 + 3); // random para tiempo de powerup

        // se utilizan para que el jframe escuche al teclado y mouse
        addKeyListener(this);
        addMouseListener(this);
    }
    
   

    
    /**
     * Metodo <I>start</I> sobrescrito de la clase <code>Applet</code>.<P>
     * En este metodo se crea e inicializa el hilo para la animacion este metodo
     * es llamado despues del init o cuando el usuario visita otra pagina y
     * luego regresa a la pagina en donde esta este <code>Applet</code>
     *
     */
    public void start() {
        //Crea el thread
        Thread th = new Thread(this);
        //Inicializa el thread
        th.start();
    }  
    
    /**
     * Metodo <I>run</I> sobrescrito de la clase <code>Thread</code>.<P>
     * En este metodo se ejecuta el hilo, es un ciclo indefinido donde se
     * incrementa la posicion en x o y dependiendo de la direccion, finalmente
     * se repinta el <code>Applet</code> y luego manda a dormir el hilo.
     *
     */    
    public void run() {
        // se realiza el ciclo del juego mientras las vidas no se acaben
        while (true) {
            /* mientras no esté en pausa el jueg, se actualizan posiciones 
            de personajes, se checa si hubo colisiones para desaparecer 
            personajes o corregir movimientos y se vuelve a pintar todo
            */ 
            if (!bPausa) {
            actualiza();
            checaColision();
            repaint();
            }
            
            try	{
                // El thread se duerme.
                Thread.sleep (20);
            }
            catch (InterruptedException iexError)	{
                System.out.println("Hubo un error en el juego " + 
                        iexError.toString());
            }
	}           
    }


     /**
     * El método actualiza() actualiza la animación
     */
        
    public void actualiza() {
        // si se encuentra en menu principal, desactiva pantalla de juego
        if (bMenuPrincipal) {
            bPantallaJuego = false;
        }
        // si se encuentra en pantalla controles, desactiva pantalla de juego
        if (bPantallaControles) {
            bPantallaJuego = false;
        }
        // si se encuentra en pantalla creditos, desactiva pantalla de juego
        if (bPantallaCreditos) {
            bPantallaJuego = false;
        }
        //si se encuentra en pantalla instrucciones, desactiva pantalla de juego
        if (bPantallaInstrucciones) {
            bPantallaJuego = false;
        }
        // si está en menu principal, posiciona a carro 1 fuera del jframe
        if (bMenuPrincipal) {
            basCarro1.setX(getWidth() + 1000);
        }
       // si el puntaje es igual a tres, muestra texto de nivel 2
        if (iPuntaje >= 3) {
            nivel2 = true;
        }

        // si se da click en boton salir desde el menu principal, sale del juego
        if (bPantallaSalir) {
           System.exit(0);
        }
        // si se encuentra en la pantalla del juego y tiene vidas
        if (bPantallaJuego && iVidas>0) {
            //souSonidoFondo.play();
            bAvanzando = true;
            // si puntaje es menor a 1, despliega texto de nivel 1
            if (iPuntaje < 1) {
                bImagenNivel1 = true;
            } else {
                bImagenNivel1 = false;  // si no, no lo despliega
            }
            // si el puntaje es de más de 9 y menos de 12, muestra texto nivel 2
            if (iPuntaje > 9 && iPuntaje <12) {
                bImagenNivel2 = true;
            }
            else {
                bImagenNivel2 = false; // si no esta en el rango, no lo muestra
            }
            // si el iSeleccionObstaculo es 1, pinta al carro1 
            if (iSeleccionObstaculo == 1) {
                bCarro1 = true;
            }
            // si el carro 1 esta pintado, da una velocidad y movimiento 
            if (bCarro1) {
                basCarro1.setVelocidad(iVelocidadJuego);
                basCarro1.izquierda();
            }
            
            // si el iSeleccionObstaculo es 2, pinta al carro2
            if (iSeleccionObstaculo == 2) {
                bCarro2 = true;
            }
            // si el carro 2 esta pintado, da una velocidad y movimiento 
            if (bCarro2) {
                basCarro2.setVelocidad(iVelocidadJuego);
                basCarro2.izquierda();
            }
            
            // si el iSeleccionObstaculo es 3, pinta Picos
            if (iSeleccionObstaculo == 3) {
                bPicos = true;
            }
            // si los picos estan pintados, da una velocidad y movimiento
            if (bPicos) {
                basPicos.setVelocidad(iVelocidadJuego);
                basPicos.izquierda(); 
            }
            // si el iSeleccionObstaculo es 3, pinta Picos 2
            if (iSeleccionObstaculo == 3) {
                bPicos2 = true;
            }
            // si los picos 2 estan pintados, da una velocidad y movimiento
            if (bPicos2) {
                basPicos2.setVelocidad(iVelocidadJuego);
                basPicos2.izquierda(); 
            }
            // si iSeleccionObstaculo es 4, pinta bota de basura
            if (iSeleccionObstaculo == 4) {
                bBasura = true;
            }
            // si el bote de basura esta pintado, da una velocidad y movimiento
            if (bBasura) {
                basBasura.setVelocidad(iVelocidadJuego);
                basBasura.izquierda();
            }
            // si iSeleccionObstaculo es 5, pinta al perro
            if (iSeleccionObstaculo == 5) {
                bPerro = true;
            }
            // si el perro esta pintado, da una velocidad y movimiento
            if (bPerro) {
                basPerro.setVelocidad(iVelocidadJuego);
                basPerro.izquierda();
            }
 
            
            /*
             * Calle
            */
            
            // da una velocidad a la calle
            basCalle.setVelocidad(iVelocidadJuego);
            basCalle2.setVelocidad(iVelocidadJuego);
            // mueve la calle a la izuiqerda
            basCalle.izquierda();
            basCalle2.izquierda();

            // Movimiento de la calle
            if (basCalle.getX() + getWidth() >=0 ) {
                bPintaCalle2 = true;
            } else {
                bPintaCalle = false;
                basCalle.setX(getWidth() - 10);
            }
            if (basCalle2.getX() + getWidth() >= 0) {
                bPintaCalle = true;
                bPintaCalle2 = true;
            } else {
                bPintaCalle2 = false;
                basCalle2.setX(getWidth() - 10);
            } 
            /*
             * Edificios
            */
            
            // se da una velocidad y movimiento a la izquierda a los edificios
            basEdificios.setVelocidad(3);
            basEdificios2.setVelocidad(3);
            basEdificios.izquierda();
            basEdificios2.izquierda();
            
            // Movimiento de los edificios
            if (basEdificios.getX() + getWidth() >=0 ) {
                bPintaEdificios2 = true;
            } else {
                bPintaEdificios = false;
                basEdificios.setX(getWidth() - 10);
            }
            // Movimiento de los edificios
            if (basEdificios2.getX() + getWidth() >= 0) {
                bPintaEdificios = true;
                bPintaEdificios2 = true;
            } else {
                bPintaEdificios2 = false;
                basEdificios2.setX(getWidth() - 10);
            } 
            /*
            POWERUPS
            */ 
            // HoverChair
            // calcula el intervalo en el que aparece powerup
            if (iPuntaje % random == 0 && iPuntaje != 0)  {
                bHoverChair = true;
            } 
            else {
                bHoverChair = false;
            }
            // si está prendida la booleana, mueve el objeto del powerup
            if (bHoverChair) {
                basHoverChair.setVelocidad(iVelocidadJuego);
                basHoverChair.izquierda();
            }
            // si está desactivado el powerup, actuar de forma normal
            if (bActivaHoverChair && iPuntaje - iAuxPuntaje >= 2) {
                bActivaHoverChair = false;
                bHoverChair = false;
                basHoverChair.setX(getWidth()-60);
                bSalto = true;
                iVelocidadJuego = 13;
            }
            // si esta activado, aumentar velocidad 
            else if (bActivaHoverChair && iPuntaje - iAuxPuntaje < 2) {
                iVelocidadJuego += 1;
                basCalle.setX(0);
                basCalle2.setX(getWidth() - 2);
            }
            
            
        


            /*
            *   RELACIONADO A LA ANIMACION  
            */
            //Determina el tiempo que ha transcurrido desde que el Applet 
            //inicio su ejecución
            if (bPantallaJuego) {
                long tiempoTranscurrido=System.currentTimeMillis()
                        - tiempoActual;
                //Guarda el tiempo actual
                tiempoActual += tiempoTranscurrido;
                //Actualiza la animación en base al tiempo transcurrido
                animAvanzando.actualiza(tiempoTranscurrido);
                animDano.actualiza(tiempoTranscurrido);
                animSaltando.actualiza(tiempoTranscurrido);
                animHoverChair.actualiza(tiempoTranscurrido);
                animPerro.actualiza(tiempoTranscurrido);
            }

    
            /*
            *   Salto
            */
            if (bSalto){
                iVelocidadY += iGravedad;   // suma gravedad a velocidad
                // actualiza posicion del personaje
                perPersonaje.setY(perPersonaje.getY() + iVelocidadY); 

                // si ya toco el suelo 
                if (perPersonaje.getY() >= 400){
                    perPersonaje.setY(perPersonaje.getY());
                    iVelocidadY =0;
                    bTocandoSuelo = true;
                    bSalto = false;
                    iContAlturaSalto = 0;
                }
            }
            // controla la longitud del salto 
            if (bCargandoSalto && (iContAlturaSalto < 15)) {
                iContAlturaSalto++;
            }
            
        }
        // si se acaban las vidas, se termina el juego
        if (iVidas == 0) {
                bPantallaJuego = false;
                bPantallaGameOver = true;
            }
        
        
        
    }
       
    /**
     * checaColision
     * 
     * Metodo usado para checar la colision del personaje principal y obstaculos
     * 
     */
    public void checaColision() {
        // si personaje y carro 1 chocan
        if (perPersonaje.colisiona(basCarro1)) {
            souColision.play();         // suena sonido de colisión
            bColision = true;           // prende colisión
            basCarro1.setX(getWidth() + 10);    // se reacomoda carro1
            bCarro1 = false;            // deja de pintar carro 1
            iVidas -= 1;            // disminuye vida
            iSeleccionObstaculo = 2;    // selecciona al obstaculo 2
        } 
        else {
            bColision = false;      // no hay colisión
        }
        
        // si el carro 1 o carro 2 se salen del jframe
        if (basCarro1.getX() + basCarro1.getAncho()< 0) {
            basCarro1.setX(getWidth() + 0);     // reposiciona carro 1
            bCarro1 = false;            // no pinta carro 1
            iSeleccionObstaculo = 2;        // seleciona al obstaculo 2
            iPuntaje += 1;          // aumenta puntaje
                    
        }
        // si personaje y carro 2 chocan
        if (perPersonaje.colisiona(basCarro2)) {  
            souColision.play();         // suena colisión
            bColision = true;           // activa colisión
            basCarro2.setX(getWidth() + 10);    // se reacomoda  carro2
            bCarro2 = false;            // deja de pintar carro 2
            iVidas -= 1;        // disminuye vida
            iSeleccionObstaculo = 5;        // selecciona obstaculo 3
        }
       
        // si carro 2 sale del jframe
        if (basCarro2.getX() + basCarro2.getAncho() < 0) {
            basCarro2.setX(getWidth() + 10);        // reposiciona carro 2
            iSeleccionObstaculo = 5;            // selecciona obstaculo 4
            bCarro2 = false;        // deja de puntar carro 2
            iPuntaje += 1;          // aumenta puntaje
        }
        // si personaje y picos chocan
        if (perPersonaje.colisiona(basPicos)) { 
            souColision.play();         // suena colisión
            bColision = true;           // activa colisión
            basPicos.setX(getWidth() + 20);    // se reacomodan picos
            bPicos = false;             // deja de pintar picos
            iVidas -= 1;        // disminuye vida
        }
        // si picos salen del jframe
        if (basPicos.getX() + basPicos.getAncho() < 0) {
            basPicos.setX(getWidth() + 10);         // reposiciona picos     
            bPicos = false;         // deja de pintar picos
            iPuntaje += 1;              // aumenta puntaje
        }
        // si personaje y picos 2 chocan
        if (perPersonaje.colisiona(basPicos2)) {   
            souColision.play();             // suena sonido de colisión
            bColision = true;               // activa colisión
            basPicos2.setX(getWidth() + 20);    // se reacomodan picos 2
            bPicos2 = false;                // deja de pintar colisión
            iVidas -= 1;        // disminuye vida
            iSeleccionObstaculo = 3;            // selecciona obstaculo 1
        }
        // si picos 2 salen del jframe
        if (basPicos2.getX() + basPicos2.getAncho() < 0) {
            basPicos2.setX(getWidth() + 10);        // reposiciona picos 2
            iSeleccionObstaculo = 3;        // selecciona obstaculo 1
            bPicos2 = false;            // deja de puntar picos 2
            iPuntaje += 1;          // aumenta puntaje 
        }
        
        // si personaje y bote de basura chocan
        if (perPersonaje.colisiona(basBasura)) {
            souColision.play();             // suena colisión
            bColision = true;           // activa colisión
            basBasura.setX(getWidth() + 10);      // reposiciona bote de basura
            iSeleccionObstaculo = 1;            // selecciona obstaculo 5
            bBasura = false;                // deja de pintar bote de basura
            iVidas -= 1;            // disminuye vida
        }
        // si el bote de basura sale del jframe
        if (basBasura.getX() + basBasura.getAncho() < 0) {
            basBasura.setX(getWidth() + 10);      // reposiciona bote de basura
            iSeleccionObstaculo = 1;            // selecciona obstaculo 2   
            bBasura = false;                // deja de pintar bote de basura
            iPuntaje += 1;              // aumenta puntaje
        }
        // si personaje y objeto de powerup hoverchair colisionan
        if (perPersonaje.colisiona(basHoverChair)) {
            basHoverChair.setX(getWidth() + 100); // reposiciona powerup
            souPowerUp.play();              // reproducir sonido de powerup
            bSalto = false;         // desactivar animacion salto
            bHoverChair = false;            // dejar de pintar objeto de powerup
            iAuxPuntaje = iPuntaje;    // almacena puntaje al hacer colision
            bActivaHoverChair = true;       // activa powerup hoverchair
        }
        // si objeto powerup hoverchair sale del jframe
        if (basHoverChair.getX() + basHoverChair.getAncho() < 0) {
            basHoverChair.setX(getWidth() + 40);  // reposiciona objeto powerup
            bHoverChair = false;        // deja de pintar objeto powerup
        }
        
        // si personaje y pero colisionan
        if (perPersonaje.colisiona(basPerro)) {
            souColision.play();
            bColision = true;
            basPerro.setX(getWidth() + 10);
            iSeleccionObstaculo = 4;
            bPerro = false;
            iVidas -= 1;
        }
        // si el perro sale del jframe
        if (basPerro.getX() + basPerro.getAncho() < 0) {
            basPerro.setX(getWidth() + 10);      // reposiciona bote de basura
            iSeleccionObstaculo = 4;            // selecciona obstaculo 2   
            bPerro = false;                // deja de pintar bote de basura
            iPuntaje += 1;              // aumenta puntaje
        }
             
 
        
        
    }
    /**
     * Metodo <I>update</I> sobrescrito de la clase <code>Applet</code>,
     * heredado de la clase Container.<P>
     * En este metodo lo que hace es actualizar el contenedor
     *
     * @param g es el <code>objeto grafico</code> usado para dibujar.
     */
    public void paint(Graphics g) {
        // Inicializan el DoubleBuffer
        if (imaImagenApplet == null) {
            imaImagenApplet = createImage(this.getSize().width, 
                    this.getSize().height);
            graGraficaApplet = imaImagenApplet.getGraphics();
        }

        // pinta fondo de cerro de la silla
        URL urlImagenCerroSilla = this.getClass().getResource("CerroSilla.png");
        Image imaImagenCerroSilla = Toolkit.getDefaultToolkit().
                getImage(urlImagenCerroSilla);
        
        // Despliego la imagen
        graGraficaApplet.drawImage(imaImagenCerroSilla, 0, 0, 
                getWidth(), getHeight(), this);
        
          
        // Actualiza la imagen de fondo.
        //graGraficaApplet.setColor(getBackground());
        //graGraficaApplet.fillRect(0, 0, this.getSize().width, 
                //this.getSize().height);

        // Actualiza el Foreground.
        //graGraficaApplet.setColor(getForeground());
        //paint1(graGraficaApplet);

        graGraficaApplet.setColor (getForeground());
        paint1(graGraficaApplet);
        
        
        // Dibuja la imagen actualizada
        g.drawImage(imaImagenApplet, 0, 0, this);        
    }
    
    /**
     * Metodo <I>paint</I> sobrescrito de la clase <code>Applet</code>, heredado
     * de la clase Container.<P>
     * En este metodo se dibuja la imagen con la posicion actualizada, ademas
     * que cuando la imagen es cargada te despliega una advertencia.
     *
     * @param g es el <code>objeto grafico</code> usado para dibujar.
     */
    public void paint1(Graphics g) {  
        if (bBootLogo) {
            g.drawImage(imaBootLogo, 0, 0, this);
        }
        
        /*
        *   Pantalla del Juego
        */
        // si se encuentra en pantalla del juego
        if (bPantallaJuego) {
            // pintar puntaje
            g.setFont(new Font("Jokerman", Font.BOLD, 40));
            g.drawString(" " + iPuntaje,550,100);
            
            if (basCalle != null && basCalle2 != null && basEdificios != null 
                    && basEdificios2 != null && basCarro1 != null) {
                // pinta edificios
                if (bPintaEdificios) { 
                    g.drawImage(basEdificios.getImagen(),basEdificios.getX(), 
                            basEdificios.getY(),
                        getWidth(),basEdificios.getAlto() + 10 ,this);                
                }
                // pinta edificios 2
                if (bPintaEdificios2) {
                    g.drawImage(basEdificios2.getImagen(),basEdificios2.getX(),
                            basEdificios2.getY(),
                       getWidth(),basEdificios2.getAlto() + 10 ,this);                
                }
                // pinta calle
                if (bPintaCalle) {
                    g.drawImage(basCalle.getImagen(),basCalle.getX(),
                            basCalle.getY(),
                        getWidth() ,basCalle.getAlto() / 2,this);
                }
                // pinta calle 2
                if (bPintaCalle2) {
                    g.drawImage(basCalle2.getImagen(),basCalle2.getX(),
                            basCalle2.getY(),getWidth(),basCalle2.getAlto() / 2,
                            this);
                }
                // pinta carro 1
                if (bCarro1) {
                    g.drawImage(basCarro1.getImagen(), basCarro1.getX(),
                            basCarro1.getY(), this);
                }
                // pinta carro 2
                if (bCarro2) {
                    g.drawImage(basCarro2.getImagen(), basCarro2.getX(),
                            basCarro2.getY(), this);
                }
                // pinta picos
                if (bPicos) {
                    g.drawImage(basPicos.getImagen(), basPicos.getX(),
                            basPicos.getY(), this);
                }
                // pinta picos 2
                if (bPicos2) {
                    g.drawImage(basPicos2.getImagen(), basPicos2.getX(),
                            basPicos2.getY(), this);
                }
                // pinta imagen nivel 1
                if (bImagenNivel1) {
                    g.drawImage(imaNivel1,getWidth() / 2 - 
                            imaNivel1.getWidth(this) / 2 ,15,this);
                }
                // pinta imagen nivel 2
                if (bImagenNivel2) {
                    g.drawImage(imaNivel2,getWidth() / 2 - 
                            imaNivel2.getWidth(this) / 2 ,15,this);
                }
                // pinta bote de basura
                if (bBasura) {
                    g.drawImage(basBasura.getImagen(), basBasura.getX(),
                            basBasura.getY(), this);
                }
                // pinta objeto de powerup hoverchair
                if (bHoverChair) {
                    g.drawImage(basHoverChair.getImagen(), basHoverChair.getX(),
                            basHoverChair.getY(), this);
                }
                if (bPerro) {
                    g.drawImage(animPerro.getImagen(), basPerro.getX() ,basPerro.getY(),this);
                }
                
            } else {
                //Da un mensaje mientras se carga el dibujo	
                g.drawString("No se cargo la imagen..", 20, 20);
            }


            /*
            *   Personaje
            */
            if (bSalto){    // si salta desplegar animación de salto
                if (animSaltando != null) {   
                    g.drawImage(animSaltando.getImagen(), perPersonaje.getX(),
                            perPersonaje.getY(), this);
                }
            }   // si se activa el powerup hoverchair, despliega animación 
                // de powerup, desactiva animación de salto y avanzando
            else if (bActivaHoverChair) {
                    bSalto = false;
                    bAvanzando = false;
                     if (animHoverChair != null) { 
                        g.drawImage(animHoverChair.getImagen(), 
                                perPersonaje.getX(),perPersonaje.getY(), this);
                    }
            }
            // si colisiona, despliega animación de colision
            else if (bColision) {
                    if (animDano != null) {
                        g.drawImage(animDano.getImagen(), perPersonaje.getX(),
                                perPersonaje.getY(), this);
                    }   
            }
            // si se encuentra avanzando, despliega animación de avanzando
            else if (bAvanzando){
                  // si solo avanza desplegar animación moviéndose
                    if (animAvanzando != null) {   
                        g.drawImage(animAvanzando.getImagen(),
                                perPersonaje.getX(),perPersonaje.getY(),this);
                    }
            }
            
        

        
        
        // pinta en pantalla de pausa
        if (bPausa){
             g.drawImage(basPausa.getImagen(), getWidth() / 2 - 300 , 
                     0 ,this);
             g.drawImage(basPausaContinuar.getImagen(), getWidth()/2 - 100,
                     180,this);
             g.drawImage(basPausaMenuPrincipal.getImagen(), getWidth()/2 - 100,
                     280,this);
             g.drawImage(basPausaRegresar.getImagen(), getWidth()/2 - 100,
                     370,this);
             g.drawImage(basPausaSalir.getImagen(), getWidth()/2 - 100,
                     450,this);
        }
        
        
        /*
        *   VIDAS
        */
        if (iVidas == 3){
            g.drawImage(basVida1.getImagen(),15,30,this);
            g.drawImage(basVida2.getImagen(),65,30,this);
            g.drawImage(basVida3.getImagen(),115,30,this);
        }
        else if (iVidas == 2){
            g.drawImage(basVida1.getImagen(),15,30,this);
            g.drawImage(basVida2.getImagen(),65,30,this);
        }        
        else if(iVidas == 1){
            g.drawImage(basVida1.getImagen(),15,30,this);
        }
        
      
        
        }
        // pinta en la pantalla menu principal
        if (bMenuPrincipal) {
            g.drawImage(imaMenuPrincipal, 0, 15, this);
            
            g.drawImage(basBotonJugar.getImagen(), basBotonJugar.getX(),
                    basBotonJugar.getY(),this);
            
            g.drawImage(basBotonInstrucciones.getImagen(), 
                    basBotonInstrucciones.getX(),basBotonInstrucciones.getY(),
                    this);
            
            g.drawImage(basBotonControles.getImagen(), basBotonControles.getX(),
                    basBotonControles.getY(),this);
            
            g.drawImage(basBotonCreditos.getImagen(), basBotonCreditos.getX(),
                    basBotonCreditos.getY(),this);
            
            g.drawImage(basBotonSalir.getImagen(), basBotonSalir.getX(),
                    basBotonSalir.getY(),this);
            
        }
        // pinta en la pantalla instrucciones
        if (bPantallaInstrucciones) {
            g.drawImage(imaPantallaInstrucciones, 0, 15, this);
            g.drawImage(basBotonJugar2.getImagen(), basBotonJugar2.getX(),
                    basBotonJugar2.getY(), this);
            g.drawImage(basBotonRegresar2.getImagen(), basBotonRegresar2.getX(),
                    basBotonRegresar2.getY(), this);    
        }
        // pinta en la pantalla controles
        if(bPantallaControles) {
            g.drawImage(imaPantallaControles, 0, 15, this);
            g.drawImage(basBotonJugar2.getImagen(), basBotonJugar2.getX(),
                    basBotonJugar2.getY(), this);
            g.drawImage(basBotonRegresar2.getImagen(), basBotonRegresar2.getX(),
                    basBotonRegresar2.getY(), this);            
        }
        // pinta en la pantalla creditos
        if (bPantallaCreditos) {
            g.drawImage(imaPantallaCreditos, 0, 15, this);
            g.drawImage(basBotonJugar2.getImagen(), basBotonJugar2.getX(),
                    basBotonJugar2.getY(), this);
            g.drawImage(basBotonRegresar2.getImagen(), basBotonRegresar2.getX(),
                    basBotonRegresar2.getY(), this);            
        }
        // pinta en la pantalla game over
        if (bPantallaGameOver) {
            g.drawImage(imaPantallaGameOver, 0, 15, this);
            g.drawImage(basBotonRegresarAMenu.getImagen(), 
                    basBotonRegresarAMenu.getX(), 
                    basBotonRegresarAMenu.getY(),this);
            g.drawImage(basBotonVolverAJugar.getImagen(), 
                    basBotonVolverAJugar.getX(), 
                    basBotonVolverAJugar.getY(),this);
            g.drawImage(basBotonSalir2.getImagen(),basBotonSalir2.getX(),
                    basBotonSalir2.getY(),this);
            g.setColor(Color.WHITE);
            g.drawString("Puntaje = " + iPuntaje,880,350);
        }
    }  

   
    
    
    
    
    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent mouEvent) {
        // si se encuentra en el menu principal
        if (bMenuPrincipal) {
            // si presiona boton jugar, inicia juego
            if (basBotonJugar.colisiona(mouEvent.getX(),mouEvent.getY())) {
                bMenuPrincipal = false;
                bPantallaJuego = true; 

            }
            // si presiona boton instrucciones, abre pantalla instrucciones
            if (basBotonInstrucciones.
                    colisiona(mouEvent.getX(),mouEvent.getY())) {
                bMenuPrincipal = false;
                bPantallaJuego = false;
                bPantallaInstrucciones = true;
            }
            // si presiona boton controles, abre pantalla controles
            if (basBotonControles.colisiona(mouEvent.getX(),mouEvent.getY())) {
                bMenuPrincipal = false;
                bPantallaJuego = false;
                bPantallaControles= true;
            }
            // si presiona boton creditos, abre pantalla controles
            if (basBotonCreditos.colisiona(mouEvent.getX(),mouEvent.getY())) {
                bMenuPrincipal = false;
                bPantallaJuego = false;
                bPantallaCreditos = true;
            }
            // si presiona boton salir, sale del jeugo
            if (basBotonSalir.colisiona(mouEvent.getX(),mouEvent.getY())) {
                bMenuPrincipal = false;
                bPantallaSalir = true;
            }  
            bPantallaGameOver = false;
        }
        //si se encuentra en pantallas de instrucciones, controles o creditos
        if (bPantallaInstrucciones || bPantallaControles || bPantallaCreditos) {
            // si presiona boton Jugar, inicia el juego
            if (basBotonJugar2.colisiona(mouEvent.getX(), mouEvent.getY())) {
                bPantallaInstrucciones = false;
                bPantallaControles = false;
                bPantallaCreditos = false;
                bPantallaJuego = true;
            }
            // si presiona boton regresar al menu 
            if (basBotonRegresar2.colisiona(mouEvent.getX(),mouEvent.getY())) {
                bPantallaInstrucciones = false;
                bPantallaControles = false;
                bPantallaCreditos = false;
                bPantallaJuego = false;
                bMenuPrincipal = true;
            }
            bPantallaGameOver = false;
        }
        // si se encuentra en pantalla de game over
        if (bPantallaGameOver) {
            // si presiona boton regresar a menu principal, regresa al menu
            if (basBotonRegresarAMenu.
                    colisiona(mouEvent.getX(), mouEvent.getY())) {
                bPantallaGameOver = false;
                bPantallaJuego = false; 
                bMenuPrincipal = true;
                iVidas = 3;
                iPuntaje = 0;
                init();
            }
            // si presiona boton volver a jugar, comienza el juego
            if (basBotonVolverAJugar.
                    colisiona(mouEvent.getX(), mouEvent.getY())) {
               bPantallaGameOver = false;
               bPantallaJuego = true;
               iVidas = 3;
               iPuntaje = 0;
               iAuxPuntaje = 0;
               
            }
            // si presiona boton salir, sale del juego
            if (basBotonSalir2.colisiona(mouEvent.getX(), mouEvent.getY())) {
                System.exit(0);
            }
            
        }
        // si esta en la pantalla de pausa
        if (bPausa){
            // si se presiona boton continuar, continua el juego
            if (basPausaContinuar.colisiona(mouEvent.getX(),mouEvent.getY())){
                bPausa = !bPausa;
            }
            // si se presiona boton regresar, continua el juego
            if (basPausaRegresar.colisiona(mouEvent.getX(),mouEvent.getY())){
                bPausa = !bPausa;
            }
            // si se presiona boton menu principal, regresa al menu principal y
            // desactiva las otras pantallas
            if (basPausaMenuPrincipal.
                    colisiona(mouEvent.getX(),mouEvent.getY())){
                bPantallaInstrucciones = false;
                bPantallaControles = false;
                bPantallaCreditos = false;
                bPausa = !bPausa;
                bPantallaJuego = false;
                bMenuPrincipal = true;
                iVidas = 3;         // reinicia vidas
                iPuntaje = 0;        // reinicia puntaje
                init();     // reinicia el juego
                
            }
            // si presiona boton salir,sale del juego
            if (basPausaSalir.colisiona(mouEvent.getX(), mouEvent.getY())) {
                System.exit(0);
            }
        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        // se utiliza para cargar el salto
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bCargandoSalto = true;
           
        }
    }
    
    public void keyReleased(KeyEvent e) {
        // si se encuentra en pantalla del juego
        if (bPantallaJuego) {
            // si presiona la tecla P, el juego se pausa o despausa
            if(e.getKeyCode() == KeyEvent.VK_P){
              bPausa = !bPausa;
            }
        
            // si presiona barra espaciadora el personaje salta
            if(e.getKeyCode() == KeyEvent.VK_SPACE){
                bCargandoSalto = false;
                if (bTocandoSuelo){
                    bSalto = true;
                    iVelocidadY = (-1* iContAlturaSalto) - 10;
                    bTocandoSuelo = false;
                }

            }
        }
    }
    
}

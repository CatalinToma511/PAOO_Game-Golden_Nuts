package PaooGame;

import PaooGame.GameWindow.GameWindow;
import PaooGame.Graphics.Assets;
import PaooGame.Input.KeyManager;
import PaooGame.States.*;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{
    private static Game instance = null;
    private GameWindow window; //fereastra jocului
    private boolean runState;
    private Thread gameThread;
    private BufferStrategy bs;

    private Graphics g;
    private State level1State;
    private State level2State;
    private State menuState;
    private State pauseState;
    private State deadScreenState;
    private State finishedLevelState;
    private State helpState;
    private KeyManager keyManager;
    private RefLinks refLink;
    private int currentLevel = 0;
    private final int maxLevels = 2;

    private Tile tile; //variabila temporara

    private Game(String title, int width, int height){
        window = new GameWindow(title, width, height);
        runState = false;
        keyManager = new KeyManager();
    }

    public static Game getInstance(String title, int width, int height){
        if(instance == null){
            instance = new Game(title, width, height);
        }
        return instance;
    }

    private void InitGame(){
        window.BuildGameWindow();
        window.GetWndFrame().addKeyListener(keyManager);
        Assets.Init();
        refLink = new RefLinks(this);
        level1State = new Level1State(refLink);
        level2State = new Level2State(refLink);
        pauseState = new PauseState(refLink);
        menuState = new MenuState(refLink);
        deadScreenState = new DeadScreenState(refLink);
        finishedLevelState = new FinishedLevelState(refLink);
        helpState = new HelpState(refLink);
        State.SetState(menuState);
    }

    public void run()
    {
        InitGame();
        long oldTime = System.nanoTime(); //timul framului anterior in ns
        long currentTime; //timpul frameului curent

        final int framesPerSecond = 60;
        final double timeFrame = (float)1000000000 / framesPerSecond;

        while(runState == true) {
            currentTime = System.nanoTime();
            if((currentTime - oldTime) > timeFrame){
                Update();
                Draw();
                oldTime = currentTime;
            }
        }
    }

    public synchronized void StartGame(){
        if(runState == false){
            runState = true;
            gameThread = new Thread(this);
            gameThread.start();
        }
        else{
            return;
        }
    }

    public synchronized void StopGame()
    {
        if(runState == true)
        {
            /// Actualizare stare thread
            runState = false;
            /// Metoda join() arunca exceptii motiv pentru care trebuie incadrata intr-un block try - catch.
            try
            {
                /// Metoda join() pune un thread in asteptare panca cand un altul isi termina executie.
                /// Totusi, in situatia de fata efectul apelului este de oprire a threadului.
                gameThread.join();
            }
            catch(InterruptedException ex)
            {
                /// In situatia in care apare o exceptie pe ecran vor fi afisate informatii utile pentru depanare.
                ex.printStackTrace();
            }
        }
        else
        {
            /// Thread-ul este oprit deja.
            return;
        }
    }

    private void Update(){
        keyManager.Update();
        if(State.GetState() != null){
            refLink.setCurrentTime(System.nanoTime());
            State.GetState().Update();
        }
    }

    private void Draw()
    {
        /// Returnez bufferStrategy pentru canvasul existent
        bs = window.GetCanvas().getBufferStrategy();
        /// Verific daca buffer strategy a fost construit sau nu
        if(bs == null)
        {
            /// Se executa doar la primul apel al metodei Draw()
            try
            {
                /// Se construieste tripul buffer
                window.GetCanvas().createBufferStrategy(3);
                return;
            }
            catch (Exception e)
            {
                /// Afisez informatii despre problema aparuta pentru depanare.
                e.printStackTrace();
            }
        }
        /// Se obtine contextul grafic curent in care se poate desena.
        g = bs.getDrawGraphics();
        /// Se sterge ce era
        g.clearRect(0, 0, window.GetWndWidth(), window.GetWndHeight());

        /// operatie de desenare
        ///Trebuie obtinuta starea curenta pentru care urmeaza a se actualiza starea, atentie trebuie sa fie diferita de null.
        if(State.GetState() != null)
        {
            ///Actualizez starea curenta a jocului daca exista.
            State.GetState().Draw(g);
        }
        /// end operatie de desenare

        /// Se afiseaza pe ecran
        bs.show();

        /// Elibereaza resursele de memorie aferente contextului grafic curent (zonele de memorie ocupate de
        /// elementele grafice ce au fost desenate pe canvas).
        g.dispose();
    }
    public int GetWidth()
    {
        return window.GetWndWidth();
    }

    /*! \fn public int GetHeight()
        \brief Returneaza inaltimea ferestrei
     */
    public int GetHeight()
    {
        return window.GetWndHeight();
    }

    /*! \fn public KeyManager GetKeyManager()
        \brief Returneaza obiectul care gestioneaza tastatura.
     */
    public KeyManager GetKeyManager()
    {
        return keyManager;
    }

    public State getLevel1State(){
        return level1State;
    }

    public State getLevel2State(){
        return level2State;
    }

    public State getPauseState(){
        return pauseState;
    }

    public State getMenuState(){
        return menuState;
    }

    public State getDeadScreenState(){
        return deadScreenState;
    }

    public State getHelpState(){
        return helpState;
    }

    public void resetLevel1(){
        level1State = null;
        level1State = new Level1State(refLink);
    }

    public void resetLevel2(){
        level2State = null;
        level2State = new Level2State(refLink);
    }

    public void setCurrentLevel(int currentLevel) {
        if(currentLevel >= 1 && currentLevel <= maxLevels) {
            this.currentLevel = currentLevel;
        }
        else
        {
            this.currentLevel = 1;
        }
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getMaxLevels(){
        return maxLevels;
    }

    public State getFinishedLevelState() {
        return finishedLevelState;
    }

}

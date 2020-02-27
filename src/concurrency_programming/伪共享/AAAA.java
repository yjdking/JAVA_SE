package concurrency_programming.伪共享;

import sun.misc.Contended;

public class AAAA {
    int x;
    @Contended
    int y;
}

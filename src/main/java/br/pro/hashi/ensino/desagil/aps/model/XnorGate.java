package br.pro.hashi.ensino.desagil.aps.model;

public class XnorGate extends Gate {

    private final NandGate nand1;
    private final NandGate nand2;
    private final NandGate nand3;
    private final NandGate nand4;
    private final NandGate nand5;

    public XnorGate() {
        super("XNOR", 2);

        nand1 = new NandGate();
        nand2 = new NandGate();
        nand3 = new NandGate();
        nand4 = new NandGate();
        nand5 = new NandGate();

        nand2.connect(1, nand1);
        nand3.connect(0, nand1);
        nand4.connect(0, nand2);
        nand4.connect(1, nand3);
        nand5.connect(0, nand4);
    }

    @Override
    public boolean read() {
        return nand5.read();
    }



    @Override
    public void connect(int inputIndex, Emitter emitter) {
        if (inputIndex == 0) {
            nand1.connect(0, emitter);
            nand2.connect(1, emitter);
            nand4.connect(0, emitter);
        }
        if (inputIndex == 1) {
            nand1.connect(0, emitter);
            nand3.connect(0, emitter);
            nand4.connect(1, emitter);
        }
    }

}

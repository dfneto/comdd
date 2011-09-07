package gerador;

public class GeradorDoDavid
{
  protected static String nl;
  public static synchronized GeradorDoDavid create(String lineSeparator)
  {
    nl = lineSeparator;
    GeradorDoDavid result = new GeradorDoDavid();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "  ";
  protected final String TEXT_2 = NL + "  ";
  protected final String TEXT_3 = NL + "  " + NL + " " + NL + " " + NL + " " + NL + " ";
  protected final String TEXT_4 = " " + NL + "/* *****************************************************************************" + NL + " * classe (\"struct\") da bussola ";
  protected final String TEXT_5 = NL + " */" + NL + "" + NL + "class Compass" + NL + "{" + NL + "    public:" + NL + "" + NL + "        double dHeading;" + NL + "        char   sHeadingStatus[5];" + NL + "        double dPitch;" + NL + "        char   sPitchStatus[5];" + NL + "        double dRoll;" + NL + "        char   sRollStatus[5];" + NL + "};";
  protected final String TEXT_6 = NL + NL + NL + NL + "/* *****************************************************************************" + NL + " * abre porta Compass" + NL + " */" + NL + "  " + NL + "void abreportaCompass()" + NL + "{" + NL + "    struct termios oldtio_cp,newtio_cp;" + NL + "    " + NL + "    iPortaCompass = open(PORTA_COMPASS, O_RDWR | O_SYNC | O_NONBLOCK, S_IRUSR | S_IWUSR );" + NL + "    // iPortaCompass = open(PORTA_COMPASS, O_RDWR | O_NOCTTY );" + NL + "    if (iPortaCompass < 0) { printf(\"\\nErro na porta %s\\n\\n\",PORTA_COMPASS); exit(0); }" + NL + "    tcgetattr(iPortaCompass,&oldtio_cp); // save current serial port settings" + NL + "    bzero(&newtio_cp, sizeof(newtio_cp)); // clear struct for new port settings" + NL + "    newtio_cp.c_cflag = BAUDRATE_COMPASS | CRTSCTS | CS8 | CLOCAL | CREAD;" + NL + "    newtio_cp.c_iflag = IGNPAR | ICRNL;" + NL + "    newtio_cp.c_oflag = 0;" + NL + "    newtio_cp.c_lflag = ICANON;" + NL + "    newtio_cp.c_cc[VINTR]    = 0;     " + NL + "    newtio_cp.c_cc[VQUIT]    = 0;     " + NL + "    newtio_cp.c_cc[VERASE]   = 0;     " + NL + "    newtio_cp.c_cc[VKILL]    = 0;    " + NL + "    newtio_cp.c_cc[VEOF]     = 4;   " + NL + "    newtio_cp.c_cc[VTIME]    = 0;     " + NL + "    newtio_cp.c_cc[VMIN]     = 1;    " + NL + "    newtio_cp.c_cc[VSWTC]    = 0;     " + NL + "    newtio_cp.c_cc[VSTART]   = 0;    " + NL + "    newtio_cp.c_cc[VSTOP]    = 0;    " + NL + "    newtio_cp.c_cc[VSUSP]    = 0;    " + NL + "    newtio_cp.c_cc[VEOL]     = 0;    " + NL + "    newtio_cp.c_cc[VREPRINT] = 0;    " + NL + "    newtio_cp.c_cc[VDISCARD] = 0;    " + NL + "    newtio_cp.c_cc[VWERASE]  = 0;    " + NL + "    newtio_cp.c_cc[VLNEXT]   = 0;     " + NL + "    newtio_cp.c_cc[VEOL2]    = 0;     " + NL + "    tcflush(iPortaCompass, TCIFLUSH);" + NL + "    tcsetattr(iPortaCompass,TCSANOW,&newtio_cp);" + NL + "}";
  protected final String TEXT_7 = NL + " ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
  Programa meuModelo = (Programa)argument;
  
    stringBuffer.append(TEXT_3);
    
if(meuModelo.plataforma.equals("Pioneer")) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(meuModelo.plataforma);
    stringBuffer.append(TEXT_5);
     } 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}


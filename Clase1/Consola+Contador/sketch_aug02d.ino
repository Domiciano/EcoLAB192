int contador=0;
int pasado=0;

void setup() {
  Serial.begin(9600);
  pinMode(8, INPUT);
}

void loop() {
  int lectura = digitalRead(8);
  
  if(pasado==LOW && lectura == HIGH){
    contador++;
  }
  Serial.println(contador);

  pasado = lectura;
}

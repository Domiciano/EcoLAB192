int contador = 0;
int pasado = 0;

void setup() {
  Serial.begin(9600);
  pinMode(2, OUTPUT);
  pinMode(3, OUTPUT);
  pinMode(4, OUTPUT);
  pinMode(5, OUTPUT);
  pinMode(8, INPUT);
}

void loop() {
  int actual = digitalRead(8);
  if(actual == HIGH){
  digitalWrite(2, HIGH);
  delay(200);
  digitalWrite(2, LOW);
  delay(200);
  }

  if(pasado == LOW && actual == HIGH){
    contador++;
  }
  
  pasado = actual;
  Serial.println(contador);
}

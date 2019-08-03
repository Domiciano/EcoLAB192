int secuencia = 0;

void setup() {
  Serial.begin(9600);
  
  pinMode(2, OUTPUT);
  pinMode(3, OUTPUT);
}

void loop() {
  digitalWrite(2, HIGH);
  digitalWrite(3, HIGH);
  secuencia++;
  Serial.println(secuencia);

  delay(500);

  digitalWrite(2, HIGH);
  digitalWrite(3, LOW);
  secuencia++;
  Serial.println(secuencia);
  
  delay(500);
  
  digitalWrite(2, LOW);
  digitalWrite(3, LOW);
  secuencia++;
  Serial.println(secuencia);
  
  delay(500);
}

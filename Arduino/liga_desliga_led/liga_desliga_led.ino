int status_led = 0;
const int pino_led = 12;

void setup() {
  Serial.begin(9600);
  pinMode(pino_led, OUTPUT);
  digitalWrite(pino_led, LOW);
}

void loop() {
  
  if(Serial.available()>0){
    
    status_led = Serial.read();
    
    if(status_led == '0'){
      
      digitalWrite(pino_led, LOW);
      
    }else if(status_led == '1'){
      
      digitalWrite(pino_led, HIGH);
      
    }
  }
}

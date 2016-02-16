namespace java com.meituan.guoning.learn

struct Person {
1: string name,
2: i32 age,
   bool married,
   i32  height
}

service Hello{
 string helloString(1:string param)
 i32 helloInt(1:i32 param)
 bool helloBoolean(1:bool param)
 void helloVoid()
 string helloNull()
 Person helloPerson(1:Person person)
}

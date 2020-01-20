# VanillaJS

- `type`과 `language` 속성은 필수가 아니다.
- Javascript는 줄 바꿈이 있으면 암시적 세미콜론으로 해석한다. 
  - 세미콜론 자동 삽입(automatic semicolon insertion)이라 칭한다.

#### 세미콜론 에러 예제 ( 결론은? 세미콜론을 생활화 하자!!)

```javascript
// 1과 2를 출력하는 foreach 문
[1,2].forEach(alert)

// 위의 경우 alert만 출력되고 에러가 발생된다.
alert("에러가 발생합니다.")

[1,2].forEach(alert)

// alert에 세미콜론을 추가 후 성공적으로 작동된다. 
// => 자바스크립트가 대괄호 [...] 앞에는 세미콜론이 있다고 가정하지 않기 때문이다.
alert("제대로 동작합니다.");

[1, 2].forEach(alert)
```



## "use strict" - 엄격 모드

- `use strict`지시자가 최상단에 명시될 경우 스크립트 전체가 `모던` 방식으로 동작한다.
- 함수 본문 앞에 명시할 경우 함수만 엄격 모드로 실행한다.
- 대부분 스크립트 전체에 적용된다.
- ES5에 추가된 키워드로 묵인했던 에러들의 에러 메시지를 발생시킨다. => 엄격하게 문법검사

### "use strict" - 브라우저 콘솔

- 테스트를 위한 브라우저 콘솔을 사용하는 경우

```javascript
//1. 콘솔창 사용할 경우
'use strict'; <Shift+Enter를 눌러 줄 바꿈 함>
//  ...테스트하려는 코드 입력
<Enter를 눌러 실행>
    
    
//2. 콘솔창에 use strict 입력이 불가능할 경우의 확실한 방법 
(function() {
  'use strict';

  // ...테스트하려는 코드...
})()
```



## undefined vs null

- `undefined`는 "값이 할당되지 않은 상태"를 나타낸다.
- `null`은 "존재하지 않는 값 / 비어있는 값 / 알 수 없는 값" 을 나타낸다.



## typeof 연산자

- 인수의 자료형을 반환 해준다.

```javascript
typeof undefined // "undefined"

typeof 0 // "number"

typeof true // "boolean"

typeof "foo" // "string"

typeof Symbol("id") // "symbol"

//수학 연산을 제공하는 내장 객체 = "object"
typeof Math // "object"  (1)

//null은 별도의 고유한 자료형을 가지는 특수 값으로 객체가 아니지만,
//자바스크립트에선 호환성을 유지하기 위해 이런 오류를 수정하지 않고 남겨둔 상황이다.
//언어 자체의 오류이므로 null이 객체가 아님에 유의하자.
typeof null // "object"  (2)

typeof alert // "function"  (3)
```



## 형 변환

- 불린 형 변환

  - 숫자 0, 빈 문자열, null, undefined, NaN 과 같이 직관적으로도 
    "비어있다고" 느껴지는 값들은 `false`
  - 그 외의 값은 `true`
  - **예외]** 문자열 "0"  는 빈 문자열이 아니기에 `true`

- 숫자 형 변환

  - undefined  = `NaN`
  - null = `0`
  - true / false = ` 1 / 0 `
  - string = 전달받은 문자열을 "그대로" 읽되, 처음과 끝의 공백을 무시
    문자열이 비어있을 경우 `0`, 오류 발생 시 `NaN`




## 비교 연산자

#### null vs 0

```javascript
alert( null > 0 );  // (1) false
alert( null == 0 ); // (2) false
alert( null >= 0 ); // (3) true

// >  <  >=  <= 의 동작 방식 경우 null이 숫자형으로 변환되어 0으로 계산됨
// == 동등 연산자의 경우 undefined나 null일때 형변환이 되지 않는다.
// undefined == null의 경우 true를 반환
```

#### 비교가 불가능한 undefined

```javascript
alert( undefined > 0 ); // false (1)
alert( undefined < 0 ); // false (2)
alert( undefined == 0 ); // false (3)

// >  <  >=  <= 의 동작 방식 경우 undefined는 NaN으로 변환되어 false 반환
```



## 브라우저가 제공하는 함수

#### 1. alert

- 메시지를 보여주는 창 (=: 모달창 )으로 `확인`버튼을 누를 때까지 유지

#### 2. prompt

- 텍스트 메시지와 입력 필드, 확인 및 취소 버튼이 있는 모달 창을 띄워준다.

```javascript
result = prompt(title, [default]);


// title : 사용자에게 보여줄 문자열
// default : 입력 필드의 초깃값(선택사항)
// 취소의 경우 null을 반환

// default가 없는 경우 => 입력 필드는 "undefined"로 명시된다.
let test = prompt("Test");

```

#### 3. confirm

- 매개변수로 받은 question(질문) 과 확인 취소 버튼이 있는 모달 창을 띄워준다.
- 사용자가 확인 버튼을 누르면 `true` 아니면 `false` 반환

```javascript
let isBoss = confirm("당신이 주인인가요?");

alert(isBoss); // 확인 버튼 시 true가 출력된다.
```



#### 함수 표현식

- 실제 실행 흐름이 해당 함수에 도달했을 때 함수를 생성한다.
- 실행 흐름이 함수에 도달했을 때부터 해당 함수를 사용할 수 있다.

```javascript
let sayHi = function() {
	alert("Hello");
};
```



#### 함수 선언식 

- 기존의 함수 선언문 방식
- 함수 선언문이 정의되기 전에도 호출 할 수 있다.

```javascript
function sayHi() {
	alert("Hello");
}
```



## 콜백 함수

- 함수를 함수의 인수로 전달하고, 인수로 전달한 그 함수를 "나중에 호출(called back)" 하는 것이 콜백 함수의 개념

```javascript
// ask 함수의 인수 , showOk와 showCancel은 콜백 함수 또는 콜백이라 한다.
function ask(question, yes, no) {
  if (confirm(question)) yes()
  else no();
}

function showOk() {
  alert( "동의하셨습니다." );
}

function showCancel() {
  alert( "취소 버튼을 누르셨습니다." );
}

// 사용법: 함수 showOk와 showCancel가 ask 함수의 인수로 전달됨
ask("동의하십니까?", showOk, showCancel);
```



## 화살표 함수

```javascript
// 동작은 둘다 같다.
let func = (arg1, arg2, ...argN) => expression;

let func = function(arg1, arg2, ...argN) {
    return expression;
};

//인수가 필요없을 경우  또한, 괄호는 생략할 수 없다.
let sayHi = () => alert("안녕!"); 

```





## 문자열 템플릿 ( 백틱 ` )

- 기존 문자열을 만드는 과정의 복잡함을 없애주는 `ES2015 ( ES6 )`  문자열템플릿

##### 예시

```javascript
var a = 3;
var b = 'hi';
var object = {
  c: 'friends'
};
var string = b + ', my ' + a + ' ' + object.c; // 'hi, my 3 friends'
```

##### 사용법

- 백틱 \` \` 내에 문자열과 변수의 경우 `${}` 로 감싸주어 사용하면 된다.

```javascript
// 1. 단일행
const string2 = `${b}, my ${a} ${object.c}`;

// 2. 다중행
var string3 = 'hello\nfriends!';
const string4 = `hello
friends!`;
/*
hello
friends!
*/

// 3. 백틱내 큰따옴표 작은따옴표 구분해서 쓸 필요가 없다.
const string5 = `I'm Zero`;
const string6 = `"I teach you JS"`;

// 4. 백틱 내에 백틱 사용 가능 ( 삼항 연산자의 예시 )
`${hours < 10 ? `0${hours}`: hours}`

```



## QuerySelector

- 하나 이상의 선택자를 포함한 DOMString
- CSS 선택자를 만족하는 첫 번째 `Element` 객체 반환, 없는 경우 `null`

##### 예시

```javascript
document.querySelector(selectors);

// id-selector로 동일한 요소가 여러 개일 경우 첫 번째로 사용된 ID 요소 반환
document.querySelector("#id-selector");
```



## LocalStorage

- HTML5에서 추가된 Storage로 window 객체의 하위 객체
- 영구적인 저장 방식  <-> 반대로 유효 기간의 sessionStorage가 있다.

- key-value형태로 key와 value는 항상 String 문자열이다.

##### 사용법

```javascript
// setItem(key,value). Storage에 저장하는 방법 
localStorage.colorSetting = '#a4509b';
localStorage['colorSetting'] = '#a4509b';
localStorage.setItem('colorSetting','#a4509b');
```

##### 메서드 및 속성

| 이름               | 구분   | 쿠키                                        |
| ------------------ | ------ | ------------------------------------------- |
| setItem(key,value) | 메서드 | 해당 키 값으로 데이터를 저장한다.           |
| getItem(key)       | 메서드 | 해당 키 값의 이름을 가진 데이터를 가져온다. |
| removeItem(key)    | 메서드 | 해당 키 값의 이름을 가진 데이터를 삭제한다. |
| key(index)         | 메서드 | 해당 인덱스 값을 가진 키의 이름을 가져온다. |
| clear()            | 메서드 | 모든 데이터를 삭제한다.                     |
| length             | 속성   | 저장된 데이터 수를 가져온다.                |



## Event.preventDefault

- 이벤트를 취소할 수 있는 경우, 이벤트의 전파를 막지 않고 그 이벤트를 취소한다.

- 이벤트 취소 가능 여부는 `event.cancelable`을 사용하여 확인할 수 있다.

- DOM을 통한 이벤트 전파를 막을때 `event.stopPropagation`을 사용한다.
  - `event.stopPropagation` 이벤트가 상위로 전파되지 않도록 중단한다.

- `event.stopImmediatePropagation()`
  - 이벤트가 상위 및 현재 레벨에 걸린 다른 이벤트도 동작하지 않도록 중단한다.
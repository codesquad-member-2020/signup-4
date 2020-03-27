export const MIN_AGE = 14;
export const MAX_AGE = 99;
export const REG_PATTERN = {
  userID: /^[a-z]{1}[a-z0-9-_]{4,19}$/,
  password: {
    limit: /.{8,16}$/,
    case: /^(?=.*[A-Z])/,
    number: /^(?=.*[0-9])/,
    symbol: /^(?=.*[!@#$%^*+=-])/
  },
  email: /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i,
  mobile: /^010\d{3,4}\d{4}$/g
};

export const INFO_MESSAGE = {
  userID: {
    submitMsg: '아이디를 입력해주세요.',
    errorMsg: '5~20자의 영문 소문자, 숫자, 특수기호(_)(-)만 사용가능합니다.',
    successMsg: '사용 가능한 아이디입니다.',
    overlapMsg: '이미 사용중인 아이디입니다.'
  },
  password: {
    submitMsg: '패스워드를 입력해주세요.',
    errorMsg: {
      limit: '8자 이상 16자 이하로 입력해주세요.',
      case: '영문 대문자를 최소 1자 이상 포함해주세요.',
      number: '숫자를 최소 1자 이상 포함해주세요.',
      symbol: '특수문자를 최소 1자 이상 포함해주세요.'
    },
    successMsg: '안전한 비밀번호 입니다.'
  },
  password_confirm: {
    submitMsg: '패스워드를 재입력해주세요.',
    errorMsg: '패스워드가 다릅니다.',
    successMsg: '패스워드가 일치합니다.'
  },
  birthYY: {
    submitMsg: '년도를 입력해주세요.'
  },
  birthMM: {
    submitMsg: '월을 입력해주세요.'
  },
  birthDD: {
    submitMsg: '일을 입력해주세요'
  },
  gender: {
    submitMsg: '성별을 입력해주세요.'
  },
  email: {
    submitMsg: '이메일을 입력해주세요.',
    errorMsg: '이메일 주소를 다시 확인해주세요.',
    successMsg: ''
  },
  mobile: {
    submitMsg: '휴대전화 번호를 입력해주세요.',
    errorMsg: '형식에 맞지 않는 번호입니다.',
    successMsg: ''
  },
  interest: {
    submitMsg: '관심사를 입력해주세요.',
    errorMsg: '3개 이상의 관심사를 입력해주세요.',
    successMsg: ''
  },
  agree: {
    submitMsg: '약관에 동의해주세요',
    errorMsg: '',
    successMsg: ''
  },
  common: {
    submitMsg: ''
  }
};

export const mockData = {
  user: [
    {
      userID: 'baekco',
      email: 'baekco@google.com',
      birthDate: '2020-01-01',
      mobile: '010-5555-5555',
      sex: '여자',
      interest: ['웹툰', '쇼핑', '축구']
    },
    {
      userID: 'sigrid',
      email: 'sigrid@google.com',
      birthDate: '2020-01-01',
      mobile: '010-5555-5555',
      sex: '여자',
      interest: ['웹툰', '쇼핑', '축구']
    },
    {
      userID: 'ellie',
      email: 'ellie@google.com',
      birthDate: '2020-01-01',
      mobile: '010-5555-5555',
      sex: '여자',
      interest: ['웹툰', '쇼핑', '축구']
    },
    {
      userID: 'Lin',
      email: 'Lin@google.com',
      birthDate: '2020-01-01',
      mobile: '010-5555-5555',
      sex: '여자',
      interest: ['웹툰', '쇼핑', '축구']
    }
  ]
};
export const PRIVACY_CONTENTS = `
<h3>1. 개인정보처리방침의 의의</h3>
<p>네이버는 본 개인정보처리방침을 정보통신망법을 기준으로 작성하되, 네이버 내에서의 이용자 개인정보 처리 현황을 최대한 알기 쉽고 상세하게 설명하기 위해 노력하였습니다. 이는 쉬운 용어를 사용한 개인정보처리방침 작성 원칙인 ‘Plain Language Privacy Policy(쉬운 용어를 사용한 개인정보처리방침)’를 도입한 것입니다.</p>
<h3>2. 수집하는 개인정보</h3>
<p>이용자는 회원가입을 하지 않아도 정보 검색, 뉴스 보기 등 대부분의 네이버 서비스를 회원과 동일하게 이용할 수 있습니다. 이용자가 메일, 캘린더, 카페, 블로그 등과 같이 개인화 혹은 회원제 서비스를 이용하기 위해 회원가입을 할 경우, 네이버는 서비스 이용을 위해 필요한 최소한의 개인정보를 수집합니다.</p>
<h3>3. 네이버가 수집하는 개인정보 항목 및 수집방법</h3>
<p>회사는 이용자들이 회원서비스를 이용하기 위해 회원으로 가입하실 때 서비스 제공을 위한 필수적인 정보들을 온라인상에서 입력 받고 있습니다. 회원 가입 시에 받는 필수적인 정보는 이름, 주민등록번호, 이메일주소 등입니다. 또한 양질의 서비스 제공을 위하여 이용자들이 선택적으로 입력할 수 있는 사항으로서 전화번호 등을 입력 받고 있습니다.</p>
<h3>4. 네이버가 수집하는 개인정보의 보유 및 이용기간</h3>
<p>이용자가 네이버의 회원으로서 회사에 제공하는 서비스를 이용하는 동안 회사는 이용자들의 개인정보를 계속적으로 보유하며 서비스 제공 등을 위해 이용합니다. 다만, 아래의 "6. 이용자 자신의 개인정보 관리(열람, 정정, 삭제 등)에 관한 사항" 에서 설명한 절차와 방법에 따라 회원 본인이 직접 삭제하거나 수정한 정보, 가입해지를 요청한 경우에는 재생할 수 없는 방법에 의하여 디스크에서 완전히 삭제하며 추후 열람이나 이용이 불가능한 상태로 처리됩니다.</p>
`;
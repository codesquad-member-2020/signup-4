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

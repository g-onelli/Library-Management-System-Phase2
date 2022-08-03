export class User{
    id: number;
    username: string;
    password?: string;
    role: string;
}
export class UserDto{
    id?: number;
    encodedCredentials: string;
    role: string;
}
export class PatronDto{
    id?: number;
    name: string;
    cardexpirationdate: string;
    balance: number;
    uid: number;
    username: string;
}
export class PatronEditDto{
    id?: number;
    name: string;
    cardexpirationdate: string;
    balance: number;
    username?: string;
}
export class PatronSignupDto{
    id?: number;
    name: string;
    encodedCredentials: string;
}
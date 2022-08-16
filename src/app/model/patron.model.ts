export class Patron{
    id?: number;
    name: string;
    cardexpirationdate: string;
    balance: number;
    uid: number;
    username: string;
    role: string;
    totalpages?: number;
}
export class ProfilePatron{
    id?: number;
    name: string;
    cardexpirationdate?: string;
    uid?: number;
    username?: string;
    securityQuestion: string;
    securityAnswer: string;
}
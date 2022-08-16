export class Requests{
    id?: number;
    description: string;
    submissiondate?: string;
    title: string;
    author: string;
    pid?: number;
    pname?: string;
    tpages?: number;
}
export class CompleteRequest{
    id?: number;
    author?: string;
    title?: string;
    callnumber?: number;
    genre: string;
    publisher: string;
}
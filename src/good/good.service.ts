import { Injectable } from '@nestjs/common';
import { CreateGoodDto } from './dto/create-good.dto';
import { UpdateGoodDto } from './dto/update-good.dto';

@Injectable()
export class GoodService {
  create(createGoodDto: CreateGoodDto) {
    return 'This action adds a new good';
  }

  findAll() {
    return `This action returns all good`;
  }

  findOne(id: number) {
    return `This action returns a #${id} good`;
  }

  update(id: number, updateGoodDto: UpdateGoodDto) {
    return `This action updates a #${id} good`;
  }

  remove(id: number) {
    return `This action removes a #${id} good`;
  }
}
